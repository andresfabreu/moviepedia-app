package com.moviepedia.network

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.AndroidClientEngine
import io.ktor.client.engine.android.AndroidEngineConfig
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::Json)
    singleOf(::HttpClient)
    singleOf(::ApiClient)
    singleOf(::HttpClientConfig)
    singleOf(::AndroidEngineConfig)
    singleOf(::AndroidClientEngine).bind(HttpClientEngine::class)
}