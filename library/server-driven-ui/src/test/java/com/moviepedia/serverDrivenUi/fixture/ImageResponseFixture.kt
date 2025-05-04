package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.common.ContentScaleResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.ImageResponse

internal interface ImageResponseFixture {
    fun imageResponse() = ImageResponse(
        url = "https://image.com",
        contentScale = ContentScaleResponse.FIT,
    )
}