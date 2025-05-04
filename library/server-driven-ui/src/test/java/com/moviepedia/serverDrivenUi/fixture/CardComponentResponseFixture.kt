package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.CardComponentResponse

internal interface CardComponentResponseFixture
    : TextResponseFixture, ActionResponseFixture, ImageResponseFixture {
    fun cardComponentResponse() = CardComponentResponse(
        image = imageResponse(),
        title = textResponse(),
        action = actionResponse(),
    )
}