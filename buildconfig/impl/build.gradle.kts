plugins {
    alias(libs.plugins.dev.hanasang.buildlogic.android.library)
}

android {
    namespace = "dev.hanasang.hsandroid.buildconfig.impl"
}

dependencies {
    implementation(project(":buildconfig:stub"))
}
