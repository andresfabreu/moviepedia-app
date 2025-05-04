package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.common.TextResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.TextStyleResponse

internal interface TextResponseFixture {
    fun textResponse() = TextResponse(
        text = "text",
        style = TextStyleResponse.BODY_MEDIUM,
    )
}