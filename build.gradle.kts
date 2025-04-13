import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

group = "dev.hanasang.hsandroid"

buildscript {
    dependencies {
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

plugins {
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.dependencyguard) apply false
    alias(libs.plugins.versions)
    alias(libs.plugins.dev.hanasang.buildlogic.spotless)
    alias(libs.plugins.dependencyanalysis)
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "$rootDir"
    reportfileName = "report"
}