package com.moviepedia.serverDrivenUi.data.mappers

import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.data.remote.response.component.ComponentResponse
import com.moviepedia.serverDrivenUi.domain.model.component.Component
import com.moviepedia.serverDrivenUi.fixture.CardComponentFixture
import com.moviepedia.serverDrivenUi.fixture.CardComponentResponseFixture
import com.moviepedia.serverDrivenUi.fixture.ParagraphComponentResponseFixture
import org.junit.Test
import kotlin.test.assertEquals

internal class ComponentMapperAggregatorTest
    : CardComponentResponseFixture, CardComponentFixture, ParagraphComponentResponseFixture {

    private val mapper: ComponentMapperAggregator = ComponentMapperAggregator(
        componentMappers = mapOf<String, ComponentMapper<*, *>>(
            CARD_COMPONENT_TYPE to CardComponentMapper(),
        ) as Map<String, ComponentMapper<ComponentResponse, Component>>
    )

    @Test
    fun `should transform CardComponentResponse to CardComponent`() {
        assertEquals(
            actual = mapper.transform(
                response = cardComponentResponse(),
            ),
            expected = cardComponent(),
        )
    }

    @Test
    fun `should return null`() {
        assertEquals(
            actual = mapper.transform(
                response = paragraphComponentResponse(),
            ),
            expected = null,
        )
    }
}