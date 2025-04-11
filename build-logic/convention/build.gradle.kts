group = "dev.hanasang.buildlogic"

plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.spotless.gradle.plugin)
    compileOnly(libs.detekt.gradle.plugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
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
}
