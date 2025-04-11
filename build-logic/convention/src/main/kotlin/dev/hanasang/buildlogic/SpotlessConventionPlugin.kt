package dev.hanasang.buildlogic

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class SpotlessConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.diffplug.spotless")

        extensions.configure<SpotlessExtension> {
            kotlin {
                target("**/*.kt")
                ktlint().editorConfigOverride(
                    mapOf(
                        "ktlint_standard_filename" to "true",
                        "ktlint_standard_no-wildcard-imports" to "true",
                        "ktlint_standard_max-line-length" to "120",
                        "ktlint_standard_no-consecutive-blank-lines" to "true",
                        "ktlint_standard_no-trailing-spaces" to "true",
                        "ktlint_standard_import-ordering" to "true",
                        "indent_size" to "4",
                    ),
                )
            }

            kotlinGradle {
                target("**/*.gradle.kts")
                ktlint().editorConfigOverride(
                    mapOf(
                        "ktlint_standard_filename" to "true",
                        "ktlint_standard_no-wildcard-imports" to "true",
                        "ktlint_standard_max-line-length" to "120",
                        "ktlint_standard_no-consecutive-blank-lines" to "true",
                        "ktlint_standard_no-trailing-spaces" to "true",
                        "ktlint_standard_import-ordering" to "true",
                        "indent_size" to "4",
                    ),
                )
            }
        }
    }
}
