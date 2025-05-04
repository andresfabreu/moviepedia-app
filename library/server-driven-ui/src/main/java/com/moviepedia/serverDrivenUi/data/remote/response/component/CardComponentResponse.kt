package com.moviepedia.serverDrivenUi.data.remote.response.component

import com.moviepedia.serverDrivenUi.data.remote.response.common.ActionResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.ImageResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.TextResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val CARD_COMPONENT_TYPE = "card_component_response"

@Serializable
@SerialName(CARD_COMPONENT_TYPE)
internal data class CardComponentResponse(
    val image: ImageResponse,
    val title: TextResponse,
    val action: ActionResponse?,
) : ComponentResponse() {
    override val type: String = CARD_COMPONENT_TYPE
}