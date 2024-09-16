import dev.iurysouza.modulegraph.Orientation

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.modulegraph)
}

moduleGraphConfig {
    readmePath.set("./README.md")
    heading = "## Module Graph"

    setStyleByModuleType = true
    orientation.set(Orientation.TOP_TO_BOTTOM)
}
