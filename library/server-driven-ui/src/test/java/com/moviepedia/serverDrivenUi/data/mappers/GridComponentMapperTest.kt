package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import com.moviepedia.serverDrivenUi.data.remote.response.component.PARAGRAPH_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.Component
import com.moviepedia.serverDrivenUi.fixture.GridComponentFixture
import com.moviepedia.serverDrivenUi.fixture.GridComponentResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class GridComponentMapperTest : GridComponentResponseFixture, GridComponentFixture {

    private val componentMapperAggregator: ComponentMapperAggregator = ComponentMapperAggregator(
        componentMappers = mapOf<String, ComponentMapper<*, *>>(
            CARD_COMPONENT_TYPE to CardComponentMapper(),
            PARAGRAPH_COMPONENT_TYPE to ParagraphComponentMapper(),
        ) as Map<String, ComponentMapper<ComponentResponse, Component>>
    )

    private val mapper = GridComponentMapper(
        componentMapperAggregator = lazyOf(componentMapperAggregator)
    )

    @Test
    fun `should transform GridComponentResponse to GridComponent`() {
        assertEquals(
            actual = mapper.transform(
                response = gridComponentResponse(),
            ),
            expected = gridComponent(),
        )
    }
}