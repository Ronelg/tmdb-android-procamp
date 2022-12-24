package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviestmdb.ui_tvshows.ListTitle
import com.example.moviestmdb.ui_tvshows.model.LobbyViewState
import com.example.moviestmdb.util.TmdbImageUrlProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowsScreen(
    modifier: Modifier = Modifier,
    state: LobbyViewState,
    tmdbImageUrlProvider: TmdbImageUrlProvider,
    onTileClicked: (movieId: Int) -> Unit
) {
    Column {
        TopAppBar(
            title = { Text(text = "Tv Shows") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        tint = MaterialTheme.colorScheme.onPrimary,
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Tv Shows"
                    )
                }
            })

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