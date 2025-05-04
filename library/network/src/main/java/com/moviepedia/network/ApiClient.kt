package com.moviepedia.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.utils.EmptyContent
import io.ktor.http.HttpMethod
import io.ktor.http.encodedPath

suspend inline fun <reified T> HttpResponse.transform(): T = body<T>()

suspend inline fun <reified T> ApiClient.get(
    requestPath: String,
    vararg requestParams: Pair<String, Any?>,
    requestBody: Any = EmptyContent,
): T = doRequest(
    requestMethod = HttpMethod.Get,
    requestPath,
    requestBody,
    *requestParams,
).transform()

suspend inline fun <reified T> ApiClient.post(
    requestPath: String,
    vararg requestParams: Pair<String, String>,
    requestBody: Any = EmptyContent,
): T = doRequest(
    requestMethod = HttpMethod.Post,
    requestPath,
    requestBody,
    *requestParams,
).transform()

class ApiClient internal constructor(
    private val httpClient: HttpClient,
) {
    suspend fun doRequest(
        requestMethod: HttpMethod,
        requestPath: String,
        requestBody: Any = EmptyContent,
        vararg requestParams: Pair<String, Any?>,
    ): HttpResponse = httpClient.request {
        method = requestMethod
        url { encodedPath = requestPath }
        setBody(requestBody)
        requestParams.forEach { parameter(it.first, it.second) }
    }
}
