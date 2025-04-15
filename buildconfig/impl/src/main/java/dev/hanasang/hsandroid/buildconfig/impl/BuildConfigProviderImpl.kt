package dev.hanasang.hsandroid.buildconfig.impl

import dev.hanasang.hsandroid.buildconfig.stub.BuildConfigProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BuildConfigProviderImpl @Inject constructor() : BuildConfigProvider {
    override val buildType: String
        get() = BuildConfig.BUILD_TYPE
}
