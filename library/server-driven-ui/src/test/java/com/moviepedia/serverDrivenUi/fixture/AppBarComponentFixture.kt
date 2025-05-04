package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.component.APP_BAR_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.AppBarComponent

internal interface AppBarComponentFixture : TextFixture, ActionFixture {
    fun appBarComponent() = AppBarComponent(
        type = APP_BAR_COMPONENT_TYPE,
        title = text(),
        action = action(),
    )
}