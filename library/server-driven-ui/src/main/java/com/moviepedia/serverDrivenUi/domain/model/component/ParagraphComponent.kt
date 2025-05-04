package com.moviepedia.serverDrivenUi.domain.model.component

import com.moviepedia.serverDrivenUi.domain.model.common.Text

internal data class ParagraphComponent(
    override val type: String,
    val title: Text,
    val paragraph: Text,
) : Component()