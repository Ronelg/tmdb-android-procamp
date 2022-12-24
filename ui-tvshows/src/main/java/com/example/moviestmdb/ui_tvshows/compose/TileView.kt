package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.moviestmdb.TvShow
import com.example.moviestmdb.util.TmdbImageUrlProvider

@Composable
fun TileView(
    tmdbImageUrlProvider: TmdbImageUrlProvider,
    result: TvShow, onClick: (tvShowId: Int) -> Unit
) {
    result.posterPath?.let {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(
                    tmdbImageUrlProvider.getPosterUrl(
                        path = it,
                        imageWidth = 400
                    )
                )
                    .apply(block = fun ImageRequest.Builder.() {
                        size(Size.ORIGINAL)
                    }).build()
            ),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.clickable {
                onClick(result.id)
            }
        )
    }

}