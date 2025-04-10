
# HSAndroid

Android 프로젝트 개발 생산성을 높이기 위한 개인 템플릿 레포입니다.

본 레포는 멀티 모듈 구조를 기반으로 공통 아키텍처, 디자인 시스템, 유틸리티 등을 구성하여 재사용성과 생산성을 높이는 것을 목표로 합니다.

---

## 프로젝트 구성 목적

- 공통 Architecture 설계
- 공통 Util 구성
- 디자인 시스템 구성
- Feature 개발 템플릿 제공
- 개인 개발 자산 관리 및 확장성 고려

---

## 모듈 구조
| 모듈명 | 역할 |
|-------|------|
| core-architecture | 핵심 아키텍처, Base 설계 |

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

> 해당 스크립트를 통해 Git Hooks(`commit-msg`, `pre-commit` 등)가 자동으로 심볼릭 링크되어 적용됩니다.
> 본 프로젝트는 .git/hooks 디렉토리를 기준으로 Git Hook을 관리하며, 다른 경로로 설정된 경우 install 시 자동으로 오류 및 안내가 출력됩니다.
---

## License

MIT License
