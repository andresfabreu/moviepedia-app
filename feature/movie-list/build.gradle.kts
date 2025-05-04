plugins {
    id("com.moviepedia.android-library-compose")
}

android {
    namespace = "com.moviepedia.movieList"
}

dependencies {
    implementation(project(":library:server-driven-ui"))
    implementation(project(":library:ui"))
}