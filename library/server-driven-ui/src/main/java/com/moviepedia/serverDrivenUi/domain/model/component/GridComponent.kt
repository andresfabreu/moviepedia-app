package com.moviepedia.serverDrivenUi.domain.model.component

internal data class GridComponent(
    override val type: String,
    val maxItemsInEachRow: Int,
    val components: List<Component>,
) : Component()