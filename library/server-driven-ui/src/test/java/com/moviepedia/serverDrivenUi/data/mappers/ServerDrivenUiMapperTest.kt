package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.APP_BAR_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import com.moviepedia.serverDrivenUi.domain.model.component.Component
import com.moviepedia.serverDrivenUi.fixture.ParagraphComponentResponseFixture
import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiFixture
import com.moviepedia.serverDrivenUi.fixture.ServerDrivenUiResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class ServerDrivenUiMapperTest
    : ServerDrivenUiResponseFixture, ServerDrivenUiFixture, ParagraphComponentResponseFixture {

    private val componentMapperAggregator: ComponentMapperAggregator = ComponentMapperAggregator(
        componentMappers = mapOf<String, ComponentMapper<*, *>>(
            CARD_COMPONENT_TYPE to CardComponentMapper(),
            APP_BAR_COMPONENT_TYPE to AppBarComponentMapper(),
        ) as Map<String, ComponentMapper<ComponentResponse, Component>>
    )

    private val mapper: ServerDrivenUiMapper = ServerDrivenUiMapper(
        componentMapperAggregator = componentMapperAggregator,
    )

    @Test
    fun `should transform ServerDrivenUiResponse to ServerDrivenUi`() {
        assertEquals(
            actual = mapper.transform(
                response = serverDrivenUiResponse(),
            ),
            expected = serverDrivenUi(),
        )
    }

    @Test
    fun `should return only mappable items`() {
        assertEquals(
            actual = mapper.transform(
                response = serverDrivenUiResponse().copy(
                    components = listOf(
                        cardComponentResponse(),
                        paragraphComponentResponse(),
                        paragraphComponentResponse(),
                    )
                ),
            ),
            expected = serverDrivenUi().copy(
                components = listOf(
                    cardComponent(),
                )
            ),
        )
    }
}