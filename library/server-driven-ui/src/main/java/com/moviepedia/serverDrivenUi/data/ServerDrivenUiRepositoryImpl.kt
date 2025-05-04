package com.moviepedia.serverDrivenUi.data

import com.moviepedia.serverDrivenUi.data.mappers.ServerDrivenUiMapper
import com.moviepedia.serverDrivenUi.data.remote.ServerDrivenUiApi
import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi
import com.moviepedia.serverDrivenUi.domain.ServerDrivenUiRepository

internal class ServerDrivenUiRepositoryImpl(
    private val serverDrivenUiApi: ServerDrivenUiApi,
    private val serverDrivenUiMapper: ServerDrivenUiMapper,
) : ServerDrivenUiRepository {

    override suspend fun getUi(path: String): ServerDrivenUi {
        return serverDrivenUiMapper.transform(serverDrivenUiApi.getUi(path = path))
    }

}