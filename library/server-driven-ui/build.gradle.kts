plugins {
    id("com.moviepedia.android-library-compose")
}

android {
    namespace = "com.moviepedia.serverDrivenUi"
}

dependencies {
    implementation(project(":library:ui"))

    implementation(libs.coil.compose)
    implementation(libs.coil.network)
}