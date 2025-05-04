package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.ServerDrivenUiResponse

internal interface ServerDrivenUiResponseFixture
    : AppBarComponentResponseFixture, CardComponentResponseFixture {
    fun serverDrivenUiResponse() = ServerDrivenUiResponse(
        appBar = appBarComponentResponse(),
        components = listOf(
            cardComponentResponse(),
            cardComponentResponse(),
        ),
        bottomBar = null,
    )
}