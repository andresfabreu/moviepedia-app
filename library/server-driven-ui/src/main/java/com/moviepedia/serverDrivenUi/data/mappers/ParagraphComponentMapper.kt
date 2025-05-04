package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.ParagraphComponentResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.toDomain
import com.moviepedia.serverDrivenUi.domain.model.component.ParagraphComponent

internal class ParagraphComponentMapper :
    ComponentMapper<ParagraphComponentResponse, ParagraphComponent> {
    override fun transform(response: ParagraphComponentResponse): ParagraphComponent =
        with(response) {
            ParagraphComponent(
                type = type,
                title = title.toDomain(),
                paragraph = paragraph.toDomain(),
            )
        }
}