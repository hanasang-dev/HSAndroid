package dev.hanasang.buildlogic

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

        pluginManager.apply("com.android.library")
        pluginManager.apply("org.jetbrains.kotlin.android")
        pluginManager.apply("com.google.dagger.hilt.android")
        pluginManager.apply("com.google.devtools.ksp")
        pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

        extensions.getByType<LibraryExtension>().apply {
            compileSdk = 35

            defaultConfig {
                minSdk = 24
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }

            buildFeatures {
                buildConfig = true
                compose = true
            }

            flavorDimensions += "env"
            productFlavors {
                create("dev") { dimension = "env" }
                create("prod") { dimension = "env" }
            }

            testOptions.animationsDisabled = true
        }

        extensions.getByType<KotlinAndroidProjectExtension>().apply {
            jvmToolchain(17)
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_17)
            }
        }

        plugins.withId("org.jetbrains.kotlin.kapt") {
            extensions.configure<org.jetbrains.kotlin.gradle.plugin.KaptExtension> {
                correctErrorTypes = true
            }
        }

        dependencies {
            add("implementation", platform(libs.findLibrary("androidx.compose.bom").get()))
            add("implementation", libs.findLibrary("hilt.android").get())
            add("ksp", libs.findLibrary("hilt.compiler").get())
            add("implementation", libs.findLibrary("androidx.compose.runtime").get())
            add("implementation", libs.findLibrary("androidx.compose.ui").get())
            add("implementation", libs.findLibrary("androidx.compose.foundation").get())
            add("androidTestImplementation", libs.findLibrary("kotlin.test").get())
            add("testImplementation", libs.findLibrary("kotlin.test").get())
        }
    }
}
