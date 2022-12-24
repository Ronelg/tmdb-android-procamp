package com.example.moviestmdb.ui_tvshows


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun ListTitle(text: String) {
    Text(
        text = text,
        style = TextStyle(fontSize = 20.sp)
    )
}