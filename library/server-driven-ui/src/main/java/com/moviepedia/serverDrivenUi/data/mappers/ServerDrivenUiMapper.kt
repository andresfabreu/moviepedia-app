package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.ServerDrivenUiResponse
import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi

internal class ServerDrivenUiMapper(
    private val componentMapperAggregator: ComponentMapperAggregator,
) {
    fun transform(response: ServerDrivenUiResponse): ServerDrivenUi = with(response) {
        ServerDrivenUi(
            appBar = appBar?.let(componentMapperAggregator::transform),
            components = components.mapNotNull(componentMapperAggregator::transform),
            bottomBar = bottomBar?.let(componentMapperAggregator::transform),
        )
    }
}