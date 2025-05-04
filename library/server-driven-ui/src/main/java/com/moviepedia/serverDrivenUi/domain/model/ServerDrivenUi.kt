package com.moviepedia.serverDrivenUi.domain.model

import com.moviepedia.serverDrivenUi.domain.model.component.Component

internal data class ServerDrivenUi(
    val appBar: Component?,
    val components: List<Component>,
    val bottomBar: Component?,
)