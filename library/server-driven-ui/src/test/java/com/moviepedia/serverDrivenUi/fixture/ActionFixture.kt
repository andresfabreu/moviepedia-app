package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.domain.model.common.Action
import com.moviepedia.serverDrivenUi.domain.model.common.ActionType
import com.moviepedia.serverDrivenUi.domain.model.common.NAVIGATE_BACK

internal interface ActionFixture {
    fun action() = Action(
        value = NAVIGATE_BACK,
        type = ActionType.SYSTEM,
    )
}