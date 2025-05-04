package com.moviepedia.serverDrivenUi.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviepedia.serverDrivenUi.domain.GetServerDrivenUi
import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ServerDrivenUiViewModel(
    private val getServerDrivenUi: GetServerDrivenUi,
    private val path: String,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state.asStateFlow()

    init {
        getServerDrivenUi()
    }

    fun getServerDrivenUi() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            getServerDrivenUi(path = path)
                .onSuccess { serverDrivenUi ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            serverDrivenUi = serverDrivenUi,
                        )
                    }
                }
                .onFailure { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = error
                        )
                    }
                }
        }
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val serverDrivenUi: ServerDrivenUi? = null,
        val error: Throwable? = null,
    )
}