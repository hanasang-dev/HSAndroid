group = "dev.hanasang.hsandroid"

plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.dependencyguard) apply false
    alias(libs.plugins.dev.hanasang.buildlogic.spotless)
}