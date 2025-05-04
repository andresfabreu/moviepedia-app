package com.moviepedia.network

import kotlinx.serialization.json.Json

internal fun Json(): Json = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
    isLenient = true
    explicitNulls = false
}
