package com.moviepedia.serverDrivenUi.presentation

import androidx.lifecycle.ViewModel
import com.moviepedia.serverDrivenUi.domain.model.common.Action
import com.moviepedia.serverDrivenUi.domain.model.common.ActionType
import com.moviepedia.serverDrivenUi.domain.model.common.NAVIGATE_BACK
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

internal class ActionViewModel() : ViewModel() {
    private val _event = MutableSharedFlow<Event>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )
    val event: SharedFlow<Event> = _event.asSharedFlow()

    fun handleAction(action: Action) {
        when (action.type) {
            ActionType.SYSTEM -> {
                if (action.value == NAVIGATE_BACK) {
                    _event.tryEmit(Event.NavigateBack)
                }
            }

            ActionType.DEEPLINK -> _event.tryEmit(Event.OpenUrl(url = action.value))
        }
    }

    sealed interface Event {

        data class OpenUrl(
            val url: String,
        ) : Event

        data object NavigateBack : Event
    }
}