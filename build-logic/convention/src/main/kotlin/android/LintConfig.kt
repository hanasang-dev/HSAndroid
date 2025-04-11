package android

import com.android.build.api.dsl.LibraryExtension

fun LibraryExtension.configureAndroidLint() {
    lint {
        // 경고만 띄우고 빌드는 성공 처리
        abortOnError = false
        warningsAsErrors = false
        checkDependencies = true
        checkGeneratedSources = false

        // 무쓸모 룰 제거
        disable.addAll(
            listOf(
                "ContentDescription",       // 접근성 관련 경고
                "IconMissingDensityFolder" // 저해상도 아이콘 경고
            )
        )
    }
}