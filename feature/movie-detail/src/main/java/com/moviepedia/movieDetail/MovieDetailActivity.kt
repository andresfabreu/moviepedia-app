package com.moviepedia.movieDetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.moviepedia.serverDrivenUi.presentation.compose.ServerDrivenUi
import com.moviepedia.ui.extensions.setThemedContent

internal class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setThemedContent {
            MovieDetailScreen(
                id = intent?.data?.lastPathSegment,
                onNavigateBack = onBackPressedDispatcher::onBackPressed,
            )
        }
    }
}

@Composable
private fun MovieDetailScreen(
    id: String?,
    onNavigateBack: () -> Unit
) {
    id?.let { id ->
        ServerDrivenUi(
            path = "/details/$id",
            onNavigateBack = onNavigateBack,
        )
    }
}