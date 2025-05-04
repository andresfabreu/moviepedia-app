package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.CardComponentResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.toDomain
import com.moviepedia.serverDrivenUi.domain.model.component.CardComponent

internal class CardComponentMapper : ComponentMapper<CardComponentResponse, CardComponent> {
    override fun transform(response: CardComponentResponse): CardComponent =
        with(response) {
            CardComponent(
                type = type,
                title = title.toDomain(),
                image = image.toDomain(),
                action = action?.toDomain(),
            )
        }
}