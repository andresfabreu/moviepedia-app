package com.moviepedia.serverDrivenUi.domain.model.common

internal const val NAVIGATE_BACK = "NAVIGATE_BACK"

internal data class Action(
    val value: String,
    val type: ActionType,
)

internal enum class ActionType {
    SYSTEM,
    DEEPLINK,
}