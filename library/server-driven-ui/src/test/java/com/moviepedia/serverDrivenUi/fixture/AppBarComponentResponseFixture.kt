package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.AppBarComponentResponse

internal interface AppBarComponentResponseFixture : TextResponseFixture, ActionResponseFixture {
    fun appBarComponentResponse() = AppBarComponentResponse(
        title = textResponse(),
        action = actionResponse(),
    )
}