package com.moviepedia.serverDrivenUi.data.remote.response.common

import com.moviepedia.serverDrivenUi.domain.model.common.ContentScale
import com.moviepedia.serverDrivenUi.domain.model.common.Image
import kotlinx.serialization.Serializable

@Serializable
internal data class ImageResponse(
    val url: String,
    val contentScale: ContentScaleResponse,
)

@Serializable
internal enum class ContentScaleResponse {
    FILL_HEIGHT,
    FILL_WIDTH,
    FIT,
}

internal fun ImageResponse.toDomain() = Image(
    url = url,
    contentScale = when (contentScale) {
        ContentScaleResponse.FILL_HEIGHT -> ContentScale.FILL_HEIGHT
        ContentScaleResponse.FILL_WIDTH -> ContentScale.FILL_WIDTH
        ContentScaleResponse.FIT -> ContentScale.FIT
    }
)