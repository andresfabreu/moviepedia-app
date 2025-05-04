package com.moviepedia.network

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.AndroidEngineConfig

internal fun HttpClient(
    engine: HttpClientEngine,
    userConfig: HttpClientConfig<AndroidEngineConfig>,
): HttpClient = HttpClient(engine = engine, userConfig = userConfig)