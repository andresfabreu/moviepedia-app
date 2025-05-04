package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.ParagraphComponentResponse

internal interface ParagraphComponentResponseFixture : TextResponseFixture {
    fun paragraphComponentResponse() = ParagraphComponentResponse(
        title = textResponse(),
        paragraph = textResponse(),
    )
}