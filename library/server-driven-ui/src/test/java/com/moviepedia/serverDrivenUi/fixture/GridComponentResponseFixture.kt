package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.GridComponentResponse

internal interface GridComponentResponseFixture : CardComponentResponseFixture {
    fun gridComponentResponse() = GridComponentResponse(
        maxItemsInEachRow = 3,
        components = listOf(
            cardComponentResponse(),
            cardComponentResponse(),
        ),
    )
}