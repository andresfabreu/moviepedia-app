package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.domain.model.common.Text
import com.moviepedia.serverDrivenUi.domain.model.common.TextStyle

internal interface TextFixture {
    fun text() = Text(
        text = "text",
        style = TextStyle.BODY_MEDIUM,
    )
}