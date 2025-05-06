# HSAndroid

Android 프로젝트 개발 생산성을 높이기 위한 개인 템플릿 레포입니다.

본 레포는 멀티 모듈 구조를 기반으로 공통 아키텍처, 디자인 시스템, 유틸리티 등을 구성하여 재사용성과 생산성을 높이는 것을 목표로 합니다.

---

## 프로젝트 목표 및 구성 현황

이 프로젝트는 Android 개발의 구조적 기반을 마련하고, 반복 작업을 최소화하기 위한 템플릿 레포로 다음과 같은 작업이 포함되어 있습니다:

- 멀티 모듈 기반 설계 도입
- 공통 아키텍처(Core Architecture) 모듈 구성
- Gradle Convention Plugin 적용 및 build-logic 모듈 분리
- Detekt 기반 코드 스타일 및 품질 검사 도입
- Git Hook 자동 적용 스크립트 구성(`install-hooks.sh`)
- 의존성 관리 도구(Dependency Analysis, Versions Plugin 등) 적용 준비
- Spotless 및 Detekt 통합을 통한 스타일 및 품질 관리 정착
- pre-commit Hook에 Lint 및 스타일 검사 자동화 적용
- Compose Plugin 기반 UI 구성 체계 도입
- Zone 기반 분기 시스템(portal) 및 KSP 기반 콘텐츠 자동 등록 구조 구축
- 재사용 가능한 Design System 모듈 분리 및 적용
- buildconfig 모듈 기반 DI 환경 구성 및 AppConfig 주입 설계
- MVI(Mutation-Intent) 기반 단방향 상태 관리 구조 도입

실제 개발에 앞서 구조와 기반을 먼저 다지는 것을 목표로 하며, 향후 Feature 모듈 구성 및 재사용 가능한 UI 시스템 설계로 확장될 예정입니다.

---

## 모듈 구조
| 모듈명               | 역할                                           |
|--------------------|------------------------------------------------|
| core-architecture  | 핵심 아키텍처 및 Presentation, Domain 공통 설계 |
| build-logic        | Gradle Convention Plugin 정의 및 관리           |
| scripts            | Git Hook 및 유틸리티 스크립트 모음              |
| portal             | Zone 기반 분기 시스템 Composable 구현           |
| portal-compiler    | @ZoneContent 기반 KSP Processor 정의 및 코드 생성 |
| design-system      | 공통 UI 컴포넌트 및 스타일 가이드 구성           |
| buildconfig        | DI 및 앱 구성 정보(AppConfig) 제공 모듈           |

---

## 프로젝트 구성 전제

본 프로젝트는 중앙 레포지토리 통제를 위해 아래 옵션을 사용합니다.

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
```

> 만약 본 프로젝트 내 특정 모듈(`core-architecture` 등)을 외부 서브모듈로 사용하거나 별도 레포로 클론하여 사용할 경우, 위 레포지토리 설정을 해당 프로젝트의 `settings.gradle.kts` 또는 `build.gradle.kts`에 추가해 주세요.

---

## Getting Started

```bash
git clone https://github.com/hanasang-dev/HSAndroid
```
필수 Git Hook 설정:

```bash
sh scripts/install-hooks.sh
```

포털 시스템은 @ZoneContent 애너테이션 기반으로 KSP에 의해 자동 등록되며, 개발자가 ZoneContentRegistry를 직접 초기화하거나 호출할 필요는 없습니다.

> 해당 스크립트를 통해 Git Hooks(`commit-msg`, `pre-commit` 등)가 자동으로 심볼릭 링크되어 적용됩니다.
> 본 프로젝트는 .git/hooks 디렉토리를 기준으로 Git Hook을 관리하며, 다른 경로로 설정된 경우 install 시 자동으로 오류 및 안내가 출력됩니다.
---

## License

MIT License
