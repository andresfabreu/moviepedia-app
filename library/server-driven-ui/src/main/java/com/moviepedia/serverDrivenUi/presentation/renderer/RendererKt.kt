package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.moviepedia.serverDrivenUi.domain.model.common.ContentScale
import com.moviepedia.serverDrivenUi.domain.model.common.TextStyle

internal fun ContentScale.toComposeContentScale() = when (this) {
    ContentScale.FILL_HEIGHT -> androidx.compose.ui.layout.ContentScale.FillHeight
    ContentScale.FILL_WIDTH -> androidx.compose.ui.layout.ContentScale.FillWidth
    ContentScale.FIT -> androidx.compose.ui.layout.ContentScale.Fit
}

@Composable
internal fun TextStyle.toComposeTextStyle() = when (this) {
    TextStyle.TITLE_LARGE -> MaterialTheme.typography.titleLarge
    TextStyle.TITLE_SMALL -> MaterialTheme.typography.titleSmall
    TextStyle.BODY_MEDIUM -> MaterialTheme.typography.bodyMedium
}