package com.moviepedia.serverDrivenUi.presentation.compose.renderer

import com.moviepedia.serverDrivenUi.data.remote.response.component.CARD_COMPONENT_TYPE
import com.moviepedia.serverDrivenUi.domain.model.component.Component
import com.moviepedia.serverDrivenUi.fixture.CardComponentFixture
import com.moviepedia.serverDrivenUi.fixture.ParagraphComponentFixture
import com.moviepedia.serverDrivenUi.presentation.renderer.CardComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.ComponentRenderer
import com.moviepedia.serverDrivenUi.presentation.renderer.ComponentRendererAggregator
import org.junit.Test
import kotlin.test.assertEquals

internal class ComponentRendererAggregatorTest : CardComponentFixture, ParagraphComponentFixture {

    private val renderer: ComponentRendererAggregator = ComponentRendererAggregator(
        componentRenderers = mapOf<String, ComponentRenderer<*>>(
            CARD_COMPONENT_TYPE to CardComponentRenderer()
        ) as Map<String, ComponentRenderer<Component>>
    )

    @Test
    fun `should return CardComponentRenderer`() {
        assert(
            renderer.getRenderer(component = cardComponent()) is CardComponentRenderer
        )
    }

    @Test
    fun `should return null`() {
        assertEquals(
            actual = renderer.getRenderer(component = paragraphComponent()),
            expected = null,
        )
    }
}