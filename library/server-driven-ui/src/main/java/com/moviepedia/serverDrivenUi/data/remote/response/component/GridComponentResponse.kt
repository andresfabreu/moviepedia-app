package com.moviepedia.serverDrivenUi.data.remote.response.component

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val GRID_COMPONENT_TYPE = "grid_component_response"

@Serializable
@SerialName(GRID_COMPONENT_TYPE)
internal data class GridComponentResponse(
    val maxItemsInEachRow: Int,
    val components: List<ComponentResponse>,
) : ComponentResponse() {
    override val type: String = GRID_COMPONENT_TYPE
}