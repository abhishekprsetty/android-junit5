import de.mannodermaus.gradle.plugins.junit5.junitPlatform
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

buildscript {
  repositories {
    google()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
  }

  dependencies {
    val latest = Artifacts.Plugin.latestStableVersion
    classpath("de.mannodermaus.gradle.plugins:android-junit5:$latest")
  }
}

plugins {
  id("com.android.application")
  kotlin("android")
  id("jacoco")
}

apply {
  plugin("de.mannodermaus.android-junit5")
}

android {
  compileSdkVersion(Android.compileSdkVersion)

  dexOptions {
    javaMaxHeapSize = Android.javaMaxHeapSize
  }

  defaultConfig {
    applicationId = "de.mannodermaus.junit5.sample"
    minSdkVersion(Android.sampleMinSdkVersion)
    targetSdkVersion(Android.targetSdkVersion)
    versionCode = 1
    versionName = "1.0"

    // Make sure to use the AndroidJUnitRunner (or a sub-class) in order to hook in the JUnit 5 Test Builder
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    testInstrumentationRunnerArgument("runnerBuilder", "de.mannodermaus.junit5.AndroidJUnit5Builder")

    buildConfigField("boolean", "MY_VALUE", "true")
  }

  // Add Kotlin source directory to all source sets
  sourceSets.forEach {
    it.java.srcDir("src/${it.name}/kotlin")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    val options = this as KotlinJvmOptions
    options.jvmTarget = JavaVersion.VERSION_1_8.toString()
  }

  testOptions {
    junitPlatform {
      // Configure JUnit 5 tests here
      filters("debug") {
        excludeTags("slow")
      }

      // Using local dependency instead of Maven coordinates
      instrumentationTests.integrityCheckEnabled = false
    }
  }

  packagingOptions {
    exclude("META-INF/LICENSE.md")
    exclude("META-INF/LICENSE-notice.md")
  }
}

tasks.withType<Test> {
  testLogging.events = setOf(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
}

dependencies {
  implementation(Libs.kotlinStdLib)

  testImplementation(Libs.junitJupiterApi)
  testImplementation(Libs.junitJupiterParams)
  testRuntimeOnly(Libs.junitJupiterEngine)

  androidTestImplementation(Libs.junit4)
  androidTestImplementation(Libs.androidxTestRunner)

  // Android Instrumentation Tests wth JUnit 5
  androidTestImplementation(Libs.junitJupiterApi)
  androidTestImplementation(Libs.junitJupiterParams)
  androidTestImplementation(Libs.espressoCore)
  androidTestImplementation(project(":core"))
  androidTestRuntimeOnly(project(":runner"))
}
