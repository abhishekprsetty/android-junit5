import kotlin.String

/**
 * Find which updates are available by running
 *     `$ ./gradlew buildSrcVersions`
 * This will only update the comments.
 *
 * YOU are responsible for updating manually the dependency version. */
object Versions {
  const val espresso_core: String = "3.2.0"

  const val androidx_test_core: String = "1.2.0"
  const val androidx_test_monitor: String = "1.2.0"
  const val androidx_test_runner: String = "1.2.0"

  const val aapt2: String = "3.2.1-4818971"

  const val com_android_tools_build_gradle_32x: String = "3.2.1"
  const val com_android_tools_build_gradle_33x: String = "3.3.2"
  const val com_android_tools_build_gradle_34x: String = "3.4.2"
  const val com_android_tools_build_gradle_35x: String = "3.5.1"
  const val com_android_tools_build_gradle_36x: String = "3.6.0-beta01"
  const val com_android_tools_build_gradle_40x: String = "4.0.0-alpha01"
  const val com_android_tools_build_gradle: String = "3.4.2"

  const val lint_gradle: String = "26.2.1"

  const val stream: String = "1.2.1"

  const val gradle_versions_plugin: String = "0.20.0"

  const val android_maven_gradle_plugin: String = "2.1"

  const val dokka: String = "0.9.18"

  const val java_semver: String = "0.9.0"

  const val gradle_bintray_plugin: String = "1.8.4"

  const val truth: String = "0.43"

  const val truth_android: String = "1.1.0"

  const val commons_io: String = "2.6"

  const val commons_lang: String = "2.6"

  const val de_fayard_buildsrcversions_gradle_plugin: String = "0.3.2"

  const val android_junit5: String = "1.3.2.0-SNAPSHOT"

  const val de_mannodermaus_junit5: String = "0.2.2"

  const val android_maven_publish: String = "3.6.2"

  const val junit: String = "4.12"

  const val assertj_core: String = "3.11.1"

  const val org_jetbrains_kotlin: String = "1.3.21"

  const val org_jetbrains_spek: String = "1.2.1"

  const val org_jacoco_agent: String = "0.8.2"
  const val org_jacoco_ant: String = "0.8.2"

  const val junit_pioneer: String = "0.2.2" // available: "0.3.0"

  const val org_junit_jupiter: String = "5.5.2"

  const val org_junit_platform: String = "1.5.2"

  const val junit_vintage_engine: String = "5.5.2"

  const val mockito_core: String = "2.19.0" // available: "2.23.4"

    const val mockito_kotlin: String = "2.1.0"

    /**
     *
     *   To update Gradle, edit the wrapper file at path:
     *      ./gradle/wrapper/gradle-wrapper.properties
     */
    object Gradle {
        const val runningVersion: String = "5.0"

    const val currentVersion: String = "5.0"

    const val nightlyVersion: String = "5.2-20181230000028+0000"

    const val releaseCandidate: String = "5.1-rc-3"
  }
}
