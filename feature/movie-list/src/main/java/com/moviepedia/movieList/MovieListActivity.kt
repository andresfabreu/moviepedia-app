package com.moviepedia.movieList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import com.moviepedia.serverDrivenUi.presentation.compose.ServerDrivenUi
import com.moviepedia.ui.extensions.setThemedContent

internal class MovieListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setThemedContent {
            MovieListScreen()
        }
    }
}

@Composable
private fun MovieListScreen() {
    ServerDrivenUi(
        path = "movies",
    )
}