package dev.hanasang.buildlogic

import groovy.lang.GroovyObject
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependencyGuardConventionPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = with(target) {
        pluginManager.apply("com.dropbox.dependency-guard")

        extensions.getByName("dependencyGuard").let { ext ->
            (ext as GroovyObject).invokeMethod("configuration", arrayOf("prodReleaseRuntimeClasspath"))
        }
    }
}
