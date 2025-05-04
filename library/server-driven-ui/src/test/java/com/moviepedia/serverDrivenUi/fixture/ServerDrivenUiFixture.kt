package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi

internal interface ServerDrivenUiFixture : AppBarComponentFixture, CardComponentFixture {
    fun serverDrivenUi() = ServerDrivenUi(
        appBar = appBarComponent(),
        components = listOf(
            cardComponent(),
            cardComponent(),
        ),
        bottomBar = null,
    )
}