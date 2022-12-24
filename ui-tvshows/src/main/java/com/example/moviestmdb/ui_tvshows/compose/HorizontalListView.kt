package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
    ) {
        LazyRow {
            items(items = items) {
                TileView(tmdbImageUrlProvider,it, onTileClicked)
            }
        }
    }
}