package com.moviepedia.serverDrivenUi.domain.model.common

internal data class Image(
    val url: String,
    val contentScale: ContentScale,
)

internal enum class ContentScale {
    FILL_HEIGHT,
    FILL_WIDTH,
    FIT,
}