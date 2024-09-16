# Android 애플리케이션 템플릿

Android 애플리케이션 개발을 위한 템플릿 레포지토리.

## 개발 환경 설정

[GitHub Packages](https://github.com/JustBurrow?tab=packages) 읽기 권한 설정

1. [New personal access token (classic)](https://github.com/settings/tokens/new)에서 토큰을 생성.
   ![GitHub personal access token.png](doc/file/GitHub%20personal%20access%20token.png)
    - `Note` : `READ_PACKAGES_TOKEN`
    - `read:packages` 권한을 선택.
2. [`sample-configuration.json`](sample-configuration.json)를 복사해서 `configuration.json` 파일을 생성.
3. `configuration.json` 파일의 `READ_PACKAGES`를 실재 토큰으로 교체.
4. GitHub 레포지토리의 `Repository secrets`에 `READ_PACKAGES_TOKEN`을 추가.
   ![GitHub - repository - Settings - Secrets and variables - Actions - Repository secrets](doc/file/GitHub%20-%20repository%20-%20Settings%20-%20Secrets%20and%20variables%20-%20Actions%20-%20Repository%20secrets.png)
5. GitHub 레포지 설정에서 `main` 브랜치 보호 규칙 추가.
   ![main 브랜치 보호 규칙](doc/file/GitHub%20-%20repository%20-%20Settings%20-%20Rules%20-%20Rulesets%20-%20main.png)

## Module Graph

```mermaid
%%{
  init: {
    'theme': 'neutral'
  }
}%%

graph TB
  :ui --> :viewmodel
  :ui --> :ui-state
  :model --> :domain
  :app --> :model
  :app --> :ui
  :viewmodel --> :ui-state
  :viewmodel --> :model
  :viewmodel --> :domain

classDef android-library fill:#3BD482,stroke:#fff,stroke-width:2px,color:#fff;
classDef android-application fill:#2C4162,stroke:#fff,stroke-width:2px,color:#fff;
class :ui android-library
class :viewmodel android-library
class :ui-state android-library
class :model android-library
class :domain android-library
class :app android-application

```
## 문서

- [Architecture Decision Records](doc/adr/README.md)

## 참고

- [JustBurrow/packages](https://github.com/JustBurrow/packages/packages)
- [New personal access token (classic)](https://github.com/settings/tokens/new)
- [iurysza/module-graph](https://github.com/iurysza/module-graph)
- [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore)