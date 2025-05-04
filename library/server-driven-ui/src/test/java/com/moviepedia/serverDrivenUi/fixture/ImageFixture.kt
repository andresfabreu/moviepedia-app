package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.domain.model.common.ContentScale
import com.moviepedia.serverDrivenUi.domain.model.common.Image

internal interface ImageFixture {
    fun image() = Image(
        url = "https://image.com",
        contentScale = ContentScale.FIT,
    )
}