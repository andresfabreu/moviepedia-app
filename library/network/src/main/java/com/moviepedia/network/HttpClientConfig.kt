package com.moviepedia.network

import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.android.AndroidEngineConfig
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://192.168.15.8:8080/"

internal fun HttpClientConfig(
    json: Json,
) = HttpClientConfig<AndroidEngineConfig>().apply {
    install(ContentNegotiation) {
        json(json)
    }

    install(Logging) {
        level = LogLevel.ALL
    }

    defaultRequest {
        url {
            protocol = URLProtocol.HTTP
            url(BASE_URL)
            contentType(ContentType.Application.Json)
        }
    }
}