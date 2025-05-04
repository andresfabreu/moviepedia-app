package com.moviepedia.serverDrivenUi.data.remote.response.component

import kotlinx.serialization.Serializable

@Serializable
internal sealed class ComponentResponse {
    abstract val type: String
}