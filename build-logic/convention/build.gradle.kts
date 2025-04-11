group = "dev.hanasang.buildlogic"

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.spotless.gradle.plugin)
    compileOnly(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("spotlessConvention") {
            id = "dev.hanasang.buildlogic.spotless"
            implementationClass = "dev.hanasang.buildlogic.SpotlessConventionPlugin"
        }
    }
}
