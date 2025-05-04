import dev.panuszewski.gradle.pluginMarker

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(pluginMarker(libs.plugins.android.application))
    implementation(pluginMarker(libs.plugins.kotlin.android))
    implementation(pluginMarker(libs.plugins.android.library))
    implementation(pluginMarker(libs.plugins.compose.compiler))
    implementation(pluginMarker(libs.plugins.kotlin.serialization))
}