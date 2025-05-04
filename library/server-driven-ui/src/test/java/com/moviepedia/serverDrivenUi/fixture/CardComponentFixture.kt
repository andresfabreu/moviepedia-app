package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.CardComponent

internal interface CardComponentFixture : TextFixture, ActionFixture, ImageFixture {
    fun cardComponent() = CardComponent(
        type = CARD_COMPONENT_TYPE,
        image = image(),
        title = text(),
        action = action(),
    )
}