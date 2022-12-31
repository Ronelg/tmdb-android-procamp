package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviestmdb.TvShow
import com.example.moviestmdb.util.TmdbImageUrlProvider

@Composable
fun HorizontalListView(
    modifier: Modifier = Modifier,
    items: List<TvShow>,
    tmdbImageUrlProvider: TmdbImageUrlProvider,
    onTileClicked: (tvShowId: Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        LazyRow {
            items(items = items) {
                TileView(
                    modifier.padding(end = 8.dp),
                    tmdbImageUrlProvider = tmdbImageUrlProvider,
                    tvShow = it,
                    onClick = onTileClicked)
            }
        }
    }
}