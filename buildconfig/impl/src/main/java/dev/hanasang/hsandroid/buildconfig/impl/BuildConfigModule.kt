// buildconfig-impl/src/main/java/BuildConfigModule.kt
package dev.hanasang.hsandroid.buildconfig.impl

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.hanasang.hsandroid.buildconfig.stub.BuildConfigProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BuildConfigModule {
    @Binds
    @Singleton
    fun bindBuildConfigProvider(
        impl: BuildConfigProviderImpl,
    ): BuildConfigProvider
}
