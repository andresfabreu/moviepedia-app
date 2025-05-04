package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.PARAGRAPH_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.ParagraphComponent

internal interface ParagraphComponentFixture : TextFixture {
    fun paragraphComponent() = ParagraphComponent(
        type = PARAGRAPH_COMPONENT_TYPE,
        title = text(),
        paragraph = text(),
    )
}