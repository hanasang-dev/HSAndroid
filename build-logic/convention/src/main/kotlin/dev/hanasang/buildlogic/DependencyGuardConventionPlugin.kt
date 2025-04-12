package dev.hanasang.buildlogic

import org.gradle.api.Project
import org.gradle.api.Plugin


class DependencyGuardConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.dropbox.dependency-guard")

        extensions.getByName("dependencyGuard").let { ext ->
            (ext as groovy.lang.GroovyObject).setProperty(
                "configurationFiles",
                listOf("dependency-guard/dependencies.json")
            )
        }
    }
}