package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.GRID_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.GridComponent

internal interface GridComponentFixture : CardComponentFixture {
    fun gridComponent() = GridComponent(
        type = GRID_COMPONENT_TYPE,
        maxItemsInEachRow = 3,
        components = listOf(
            cardComponent(),
            cardComponent(),
        ),
    )
}