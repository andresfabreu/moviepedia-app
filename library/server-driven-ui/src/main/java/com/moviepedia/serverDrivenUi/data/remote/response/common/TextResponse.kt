package com.moviepedia.serverDrivenUi.data.remote.response.common

import com.moviepedia.serverDrivenUi.domain.model.common.Text
import com.moviepedia.serverDrivenUi.domain.model.common.TextStyle
import kotlinx.serialization.Serializable

@Serializable
internal data class TextResponse(
    val text: String,
    val style: TextStyleResponse,
)

@Serializable
internal enum class TextStyleResponse {
    TITLE_SMALL,
    TITLE_LARGE,
    BODY_MEDIUM,
}

internal fun TextResponse.toDomain() = Text(
    text = text,
    style = when (style) {
        TextStyleResponse.TITLE_SMALL -> TextStyle.TITLE_SMALL
        TextStyleResponse.TITLE_LARGE -> TextStyle.TITLE_LARGE
        TextStyleResponse.BODY_MEDIUM -> TextStyle.BODY_MEDIUM
    }
)