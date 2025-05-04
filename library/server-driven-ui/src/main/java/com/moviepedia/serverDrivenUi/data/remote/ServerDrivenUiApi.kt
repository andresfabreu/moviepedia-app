package com.moviepedia.serverDrivenUi.data.remote

import com.moviepedia.network.ApiClient
import com.moviepedia.network.get
import com.moviepedia.serverDrivenUi.data.remote.response.ServerDrivenUiResponse

internal class ServerDrivenUiApi(
    private val client: ApiClient
) {

    suspend fun getUi(path: String): ServerDrivenUiResponse {
        return client.get(
            requestPath = path
        )
    }
}