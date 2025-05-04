package com.moviepedia.serverDrivenUi.domain.model.common

internal data class Text(
    val text: String,
    val style: TextStyle,
)

internal enum class TextStyle {
    TITLE_SMALL,
    TITLE_LARGE,
    BODY_MEDIUM,
}