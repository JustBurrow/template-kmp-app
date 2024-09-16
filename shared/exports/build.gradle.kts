plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
            isStatic = true

            dependencies {
                export(projects.shared.domain)
                export(projects.shared.model)

                export(libs.kotlinx.coroutines.core)
                export(libs.kr.lul.semantic.version)
            }
        }
    }

    sourceSets {
        commonMain.dependencies {
            api(projects.shared.domain)
            api(projects.shared.model)

            api(libs.kotlinx.coroutines.core)
            api(libs.kr.lul.semantic.version)
        }
    }
}
