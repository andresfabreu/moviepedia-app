package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import com.moviepedia.serverDrivenUi.domain.model.component.Component

@Stable
internal interface ComponentRenderer<in T : Component> {

    @Composable
    fun Render(
        modifier: Modifier,
        component: T,
    )
}