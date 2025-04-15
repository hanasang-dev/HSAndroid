group = "dev.hanasang.buildlogic"

plugins {
    `kotlin-dsl`
    alias(libs.plugins.dependencyguard)
}

dependencies {
    compileOnly(libs.spotless.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.hilt.android.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("spotlessConvention") {
            id = "dev.hanasang.buildlogic.spotless"
            implementationClass = "dev.hanasang.buildlogic.SpotlessConventionPlugin"
        }
    }
    plugins {
        register("detektConvention") {
            id = "dev.hanasang.buildlogic.detekt"
            implementationClass = "dev.hanasang.buildlogic.DetektConventionPlugin"
        }
    }
    plugins {
        register("dependencyguardConvention") {
            id = "dev.hanasang.buildlogic.dependencyguard"
            implementationClass = "dev.hanasang.buildlogic.DependencyGuardConventionPlugin"
        }
    }
    plugins {
        register("androidLibraryConvention") {
            id = "dev.hanasang.buildlogic.android.library"
            implementationClass = "dev.hanasang.buildlogic.AndroidLibraryConventionPlugin"
        }
    }
}
