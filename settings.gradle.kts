pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "HSAndroid"

plugins {
    id("com.gradle.develocity") version ("4.0")
}

develocity {
    buildScan {
        termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
        termsOfUseAgree.set("yes")
    }
}
include(":buildconfig:stub")
include(":buildconfig:impl")
include(":core")
include(":core:presentation")
include(":core:presentation:portal")
include(":core:presentation:state")
include(":core:presentation:portal-compiler")
