package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.moviepedia.serverDrivenUi.domain.model.component.CardComponent
import com.moviepedia.serverDrivenUi.presentation.ActionViewModel
import org.koin.compose.viewmodel.koinViewModel

internal class CardComponentRenderer : ComponentRenderer<CardComponent> {

    @Composable
    override fun Render(
        modifier: Modifier,
        component: CardComponent,
    ) = with(component) {
        val actionViewModel = koinViewModel<ActionViewModel>()

        Card(
            modifier = modifier.padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            onClick = {
                action?.let { action ->
                    actionViewModel.handleAction(action = action)
                }
            },
        ) {
            Box(
                contentAlignment = Alignment.BottomStart,
            ) {
                val height = 128.dp
                val gradientColor = MaterialTheme.colorScheme.scrim

                AsyncImage(
                    modifier = Modifier
                        .height(height = height)
                        .fillMaxWidth()
                        .drawWithCache {
                            val gradient = Brush.verticalGradient(
                                colors = listOf(Color.Transparent, gradientColor),
                                startY = size.height / 2,
                                endY = size.height
                            )
                            onDrawWithContent {
                                drawContent()
                                drawRect(gradient, blendMode = BlendMode.Multiply)
                            }
                        },
                    model = image.url,
                    contentDescription = null,
                    contentScale = image.contentScale.toComposeContentScale(),
                )

                Text(
                    modifier = Modifier.padding(all = 8.dp),
                    text = title.text,
                    style = title.style.toComposeTextStyle(),
                )
            }
        }
    }
}