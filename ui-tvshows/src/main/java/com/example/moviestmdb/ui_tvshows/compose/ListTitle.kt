package com.example.moviestmdb.ui_tvshows.compose


import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ListTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5
    )
}