package com.moviepedia.serverDrivenUi.domain

import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi

internal class GetServerDrivenUi(
    private val serverDrivenUiRepository: ServerDrivenUiRepository
) {
    suspend operator fun invoke(path: String): Result<ServerDrivenUi> = runCatching {
        serverDrivenUiRepository.getUi(path = path)
    }
}