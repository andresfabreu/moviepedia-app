package com.moviepedia.serverDrivenUi.data.remote.response.common

import com.moviepedia.serverDrivenUi.domain.model.common.Action
import com.moviepedia.serverDrivenUi.domain.model.common.ActionType
import kotlinx.serialization.Serializable

@Serializable
internal data class ActionResponse(
    val value: String,
    val type: ActionTypeResponse,
)

@Serializable
internal enum class ActionTypeResponse {
    SYSTEM,
    DEEPLINK,
}

internal fun ActionResponse.toDomain() = Action(
    value = value,
    type = when (type) {
        ActionTypeResponse.SYSTEM -> ActionType.SYSTEM
        ActionTypeResponse.DEEPLINK -> ActionType.DEEPLINK
    }
)