package com.moviepedia.serverDrivenUi.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moviepedia.serverDrivenUi.domain.model.ServerDrivenUi
import com.moviepedia.serverDrivenUi.presentation.ActionViewModel
import com.moviepedia.serverDrivenUi.presentation.ServerDrivenUiViewModel
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ServerDrivenUi(
    path: String,
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {},
) {
    val viewModel = koinViewModel<ServerDrivenUiViewModel> { parametersOf(path) }
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.serverDrivenUi != null -> SuccessState(
            modifier = modifier,
            serverDrivenUi = requireNotNull(state.serverDrivenUi),
            isRefreshing = state.isLoading,
            onRefresh = viewModel::getServerDrivenUi,
        )

        state.isLoading -> LoadingState(
            modifier = modifier,
        )

        state.error != null -> ErrorState(
            modifier = modifier,
            error = requireNotNull(state.error),
            onRetry = viewModel::getServerDrivenUi,
        )
    }

    ActionHandler(onNavigateBack = onNavigateBack)
}

@Composable
private fun LoadingState(
    modifier: Modifier = Modifier,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .padding(paddingValues = paddingValues)
                .fillMaxSize(),
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}

@Composable
private fun ErrorState(
    modifier: Modifier = Modifier,
    error: Throwable,
    onRetry: () -> Unit,
) {
    Scaffold { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues = paddingValues)
                .padding(all = 32.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Oops, ocorreu um erro :(\nTente novamente mais tarde.",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(height = 24.dp))

            Button(onClick = onRetry) {
                Text(
                    modifier = Modifier
                        .padding(all = 4.dp)
                        .fillMaxWidth(),
                    text = "Tentar de novo",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SuccessState(
    modifier: Modifier = Modifier,
    serverDrivenUi: ServerDrivenUi,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
) {
    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        modifier = modifier
    ) {
        Scaffold(
            modifier = modifier
                .fillMaxSize(),
            topBar = { serverDrivenUi.appBar?.Render() },
            bottomBar = { serverDrivenUi.bottomBar?.Render() }
        ) { paddingValues ->
            LazyColumn(
                contentPadding = paddingValues
            ) {
                serverDrivenUi.components.forEach { component ->
                    item(contentType = component.type) {
                        component.Render()
                    }
                }
            }
        }
    }
}

@Composable
private fun ActionHandler(
    onNavigateBack: (() -> Unit),
) {
    val actionViewModel = koinViewModel<ActionViewModel>()
    val uriHandler = LocalUriHandler.current

    LaunchedEffect(actionViewModel) {
        actionViewModel.event.collect {
            when (it) {
                is ActionViewModel.Event.NavigateBack -> onNavigateBack()
                is ActionViewModel.Event.OpenUrl -> uriHandler.openUri(uri = it.url)
            }
        }
    }
}
