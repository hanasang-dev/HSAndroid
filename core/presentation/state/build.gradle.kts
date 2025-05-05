plugins {
    alias(libs.plugins.dev.hanasang.buildlogic.android.library)
    alias(libs.plugins.dev.hanasang.buildlogic.detekt)
    alias(libs.plugins.dev.hanasang.buildlogic.dependencyguard)
}

android {
    namespace = "dev.hanasang.hsandroid.core.presentation.state"
}

dependencies {
    implementation(project(":buildconfig:stub"))
}
