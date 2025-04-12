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

plugins{
    id("com.gradle.develocity") version("4.0")
}

develocity {
    buildScan {
        termsOfService {
            url.set("https://gradle.com/terms-of-service")
            agree.set("yes")
        }
        publishAlways()
    }
}