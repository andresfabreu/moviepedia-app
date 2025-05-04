package com.moviepedia.serverDrivenUi.data.remote.response.component

import com.moviepedia.serverDrivenUi.data.remote.response.common.TextResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val PARAGRAPH_COMPONENT_TYPE = "paragraph_component"

@Serializable
@SerialName(PARAGRAPH_COMPONENT_TYPE)
internal data class ParagraphComponentResponse(
    val title: TextResponse,
    val paragraph: TextResponse,
) : ComponentResponse() {
    override val type: String = PARAGRAPH_COMPONENT_TYPE
}