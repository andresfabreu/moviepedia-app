package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moviepedia.serverDrivenUi.domain.model.component.ParagraphComponent

internal class ParagraphComponentRenderer : ComponentRenderer<ParagraphComponent> {

    @Composable
    override fun Render(
        modifier: Modifier,
        component: ParagraphComponent,
    ) = with(component) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            Text(
                text = title.text,
                style = title.style.toComposeTextStyle(),
            )

            Spacer(modifier = Modifier.height(height = 8.dp))

            Text(
                text = paragraph.text,
                style = paragraph.style.toComposeTextStyle(),
            )
        }
    }
}