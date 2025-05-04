package com.moviepedia.serverDrivenUi.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviepedia.serverDrivenUi.domain.model.component.Component
import com.moviepedia.serverDrivenUi.presentation.renderer.ComponentRendererAggregator
import org.koin.compose.koinInject

@Composable
internal fun Component.Render(modifier: Modifier = Modifier) {
    val componentRendererAggregator = koinInject<ComponentRendererAggregator>()

    componentRendererAggregator.getRenderer(component = this)
        ?.Render(modifier = modifier, component = this)
}