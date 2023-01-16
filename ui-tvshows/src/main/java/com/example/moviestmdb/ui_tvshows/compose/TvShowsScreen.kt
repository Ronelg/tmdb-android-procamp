package com.example.moviestmdb.ui_tvshows.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.moviestmdb.ui_tvshows.model.LobbyViewState
import com.example.moviestmdb.ui_tvshows.theme.TmdbTheme
import com.example.moviestmdb.ui_tvshows.theme.extendedColors
import com.example.moviestmdb.util.TmdbImageUrlProvider


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                backgroundColor = MaterialTheme.colors.surface, //Same as "Widget.Tmdb.AppBar" style define
                title = { Text(text = "TV Shows",style= MaterialTheme.typography.h6) },
            )
        },
        content = {
            Column(
                modifier = modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ListTitle("Popular TV Shows")
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalListView(
                    tmdbImageUrlProvider = tmdbImageUrlProvider,
                    items = state.popularTvShows,
                    onTileClicked = onTileClicked
                )
                Spacer(modifier = Modifier.height(16.dp))
                ListTitle("Top Rated TV Shows")
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalListView(
                    tmdbImageUrlProvider = tmdbImageUrlProvider,
                    items = state.topRatedTvShows,
                    onTileClicked = onTileClicked
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    )
}