package com.moviepedia.serverDrivenUi.presentation.renderer

import com.moviepedia.serverDrivenUi.domain.model.component.Component

internal class ComponentRendererAggregator(
    private val componentRenderers: Map<String, ComponentRenderer<Component>>
) {
    fun getRenderer(component: Component): ComponentRenderer<Component>? =
        componentRenderers[component.type]
}