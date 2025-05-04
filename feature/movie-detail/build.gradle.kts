plugins {
    id("com.moviepedia.android-library-compose")
}

android {
    namespace = "com.moviepedia.movieDetail"
}

dependencies {
    implementation(project(":library:server-driven-ui"))
    implementation(project(":library:ui"))
}