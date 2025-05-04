package com.moviepedia.serverDrivenUi.domain.model.component

import com.moviepedia.serverDrivenUi.domain.model.common.Action
import com.moviepedia.serverDrivenUi.domain.model.common.Text

internal data class AppBarComponent(
    override val type: String,
    val title: Text,
    val action: Action?,
) : Component()