package com.moviepedia.serverDrivenUi.presentation.renderer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moviepedia.serverDrivenUi.domain.model.component.AppBarComponent
import com.moviepedia.serverDrivenUi.presentation.ActionViewModel
import org.koin.compose.viewmodel.koinViewModel

internal class AppBarComponentRenderer : ComponentRenderer<AppBarComponent> {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Render(
        modifier: Modifier,
        component: AppBarComponent
    ) = with(component) {
        val actionViewModel = koinViewModel<ActionViewModel>()

        TopAppBar(
            modifier = modifier,
            title = {
                Text(
                    text = title.text,
                    style = title.style.toComposeTextStyle()
                )
            },
            navigationIcon = {
                action?.let { action ->
                    IconButton(onClick = { actionViewModel.handleAction(action = action) }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "",
                        )
                    }
                }
            },
        )
    }
}