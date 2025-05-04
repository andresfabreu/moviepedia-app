package com.moviepedia.serverDrivenUi.domain.model.component

import com.moviepedia.serverDrivenUi.domain.model.common.Action
import com.moviepedia.serverDrivenUi.domain.model.common.Image
import com.moviepedia.serverDrivenUi.domain.model.common.Text

internal data class CardComponent(
    override val type: String,
    val image: Image,
    val title: Text,
    val action: Action?,
) : Component()