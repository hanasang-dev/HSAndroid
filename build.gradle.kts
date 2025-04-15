import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

group = "dev.hanasang.hsandroid"

buildscript {
    dependencies {
        classpath(libs.secrets.gradle.plugin)
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
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.dagger.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates").configure {
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "$rootDir"
    reportfileName = "report"
}
