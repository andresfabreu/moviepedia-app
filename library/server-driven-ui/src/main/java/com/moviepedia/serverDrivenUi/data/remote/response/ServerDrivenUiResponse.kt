package com.moviepedia.serverDrivenUi.data.remote.response

import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import kotlinx.serialization.Serializable

@Serializable
internal data class ServerDrivenUiResponse(
    val appBar: ComponentResponse?,
    val components: List<ComponentResponse>,
    val bottomBar: ComponentResponse?,
)