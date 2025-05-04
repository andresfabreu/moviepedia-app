package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import com.moviepedia.serverDrivenUi.domain.model.component.Component

internal class ComponentMapperAggregator(
    private val componentMappers: Map<String, ComponentMapper<ComponentResponse, Component>>
) {
    fun transform(response: ComponentResponse): Component? =
        componentMappers[response.type]?.transform(response = response)
}