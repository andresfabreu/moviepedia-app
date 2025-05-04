package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.GridComponentResponse
import com.moviepedia.serverDrivenUi.domain.model.component.GridComponent

internal class GridComponentMapper(
    private val componentMapperAggregator: Lazy<ComponentMapperAggregator>,
) : ComponentMapper<GridComponentResponse, GridComponent> {
    override fun transform(response: GridComponentResponse): GridComponent =
        with(response) {
            GridComponent(
                type = type,
                maxItemsInEachRow = maxItemsInEachRow,
                components = components.mapNotNull { componentResponse ->
                    componentMapperAggregator.value.transform(
                        response = componentResponse
                    )
                }
            )
        }
}