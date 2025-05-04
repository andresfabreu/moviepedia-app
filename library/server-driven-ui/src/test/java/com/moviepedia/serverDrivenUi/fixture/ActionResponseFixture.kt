package com.moviepedia.serverDrivenUi.fixture

import com.moviepedia.serverDrivenUi.data.remote.response.common.ActionResponse
import com.moviepedia.serverDrivenUi.data.remote.response.common.ActionTypeResponse
import com.moviepedia.serverDrivenUi.domain.model.common.NAVIGATE_BACK

internal interface ActionResponseFixture {
    fun actionResponse() = ActionResponse(
        value = NAVIGATE_BACK,
        type = ActionTypeResponse.SYSTEM,
    )
}