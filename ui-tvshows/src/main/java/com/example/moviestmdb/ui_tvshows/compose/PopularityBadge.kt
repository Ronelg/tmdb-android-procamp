package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviestmdb.core_ui.R
import com.example.moviestmdb.core_ui.R.*


@Composable
fun PopularityBadge(
    modifier: Modifier = Modifier,
    popularity: Int
) {
    Column {
        Box(
            modifier = modifier
                .size(50.dp)
                .aspectRatio(1f)
                .background(colorResource(color.tmdb_popularity_bg), shape = CircleShape),
        ) {
            CircularProgressIndicator(
                progress = popularity / 100f,
                modifier = Modifier
                    .size(size = 40.dp)
                    .align(Alignment.Center),
                color = colorResource(updateProgressColor(popularity)),
                strokeWidth = 2.dp
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.Center),
                text = "$popularity%",
                color = Color.White,
                fontSize = 10.sp
            )
        }
    }
}

@Composable
private fun updateProgressColor(progress: Int): Int {
    return when (progress) {
        in 0..29 -> {
            R.color.tmdb_popularity_low
        }
        in 30..69 -> {
            R.color.tmdb_popularity_mid
        }
        in 70..100 -> {
            R.color.tmdb_popularity_high
        }
        else -> R.color.tmdb_popularity_high
    }
}