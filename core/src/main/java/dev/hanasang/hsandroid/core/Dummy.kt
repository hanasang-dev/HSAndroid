package dev.hanasang.hsandroid.core

import dev.hanasang.hsandroid.buildconfig.stub.BuildConfigProvider

class Dummy {
    fun printBuildType(provider: BuildConfigProvider) {
        println("Build Type is: ${provider.buildType}")
    }
}
