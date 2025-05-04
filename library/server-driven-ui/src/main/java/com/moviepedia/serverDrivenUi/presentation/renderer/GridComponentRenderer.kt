package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviepedia.serverDrivenUi.domain.model.component.GridComponent
import com.moviepedia.serverDrivenUi.presentation.compose.Render

internal class GridComponentRenderer : ComponentRenderer<GridComponent> {

    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    override fun Render(
        modifier: Modifier,
        component: GridComponent,
    ) = with(component) {
        BoxWithConstraints(
            modifier = modifier,
        ) {
            val maxWidth = this.maxWidth

            FlowRow(
                maxItemsInEachRow = 3
            ) {
                components.forEach { child ->
                    child.Render(modifier = Modifier.width(width = maxWidth / 3))
                }
            }
        }
    }
}