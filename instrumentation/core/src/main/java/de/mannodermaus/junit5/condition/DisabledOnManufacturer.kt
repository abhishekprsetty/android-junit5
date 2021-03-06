package de.mannodermaus.junit5.condition

import org.junit.jupiter.api.extension.ExtendWith

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(DisabledOnManufacturerCondition::class)
annotation class DisabledOnManufacturer(val value: Array<String>, val ignoreCase: Boolean = true)
