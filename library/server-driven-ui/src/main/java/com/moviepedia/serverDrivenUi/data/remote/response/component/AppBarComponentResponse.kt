package com.moviepedia.serverDrivenUi.data.remote.response.component

import com.moviepedia.serverDrivenUi.data.remote.response.common.ActionResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.TextResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

internal const val APP_BAR_COMPONENT_TYPE = "app_bar_component"

@Serializable
@SerialName(APP_BAR_COMPONENT_TYPE)
internal data class AppBarComponentResponse(
    val title: TextResponse,
    val action: ActionResponse?,
) : ComponentResponse() {
    override val type: String = APP_BAR_COMPONENT_TYPE
}