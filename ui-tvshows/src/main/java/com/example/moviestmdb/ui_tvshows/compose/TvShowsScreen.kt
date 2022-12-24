package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.moviestmdb.ui_tvshows.model.LobbyViewState
import com.example.moviestmdb.util.TmdbImageUrlProvider


@Composable
fun TvShowsScreen(
    modifier: Modifier = Modifier,
    state: LobbyViewState,
    tmdbImageUrlProvider: TmdbImageUrlProvider,
    onTileClicked: (movieId: Int) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "TV Shows") },
            )
        },
        content = {
            Column(Modifier.padding(horizontal = 16.dp)) {
                ListTitle("Populars")
                HorizontalListView(
                    tmdbImageUrlProvider = tmdbImageUrlProvider,
                    items = state.popularTvShows,
                    onTileClicked = onTileClicked
                )

                ListTitle("Top Rated")
                HorizontalListView(
                    tmdbImageUrlProvider = tmdbImageUrlProvider,
                    items = state.topRatedTvShows,
                    onTileClicked = onTileClicked
                )
            }
        }
    )
}