import groovy.json.JsonSlurper

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

val configurations = JsonSlurper().parse(File(rootProject.projectDir, "configuration.json")) as Map<*, *>

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/JustBurrow/packages")
            credentials {
                username = configurations["READ_PACKAGES_USER"] as String?
                    ?: System.getenv("READ_PACKAGES_USER")
                password = configurations["READ_PACKAGES_TOKEN"] as String?
                    ?: System.getenv("READ_PACKAGES_TOKEN")
            }
        }
    }
}

rootProject.name = "KMP_Template"

include(
    ":android:app",
    ":android:viewmodel",
    ":android:ui",
    ":android:ui-state",

    ":shared:exports",
    ":shared:model",
    ":shared:domain"
)
