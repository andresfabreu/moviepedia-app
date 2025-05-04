package com.moviepedia.ui.extensions

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.moviepedia.ui.theme.MoviePediaTheme

fun ComponentActivity.setThemedContent(
    isDarkTheme: Boolean? = null,
    enableEdgeToEdge: Boolean = false,
    content: @Composable () -> Unit,
) {
    if (enableEdgeToEdge) {
        enableEdgeToEdge()
    }
    setContent {
        MoviePediaTheme(isDarkTheme ?: isSystemInDarkTheme(), content)
    }
}