package com.moviepedia.serverDrivenUi.domain

import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi

internal interface ServerDrivenUiRepository {
    suspend fun getUi(path: String): ServerDrivenUi
}