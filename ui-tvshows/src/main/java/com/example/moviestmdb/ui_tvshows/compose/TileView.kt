package com.example.moviestmdb.ui_tvshows.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.moviestmdb.TvShow
import com.example.moviestmdb.ui_tvshows.theme.extendedTypography
import com.example.moviestmdb.util.TmdbImageUrlProvider

@Composable
fun TileView(
    modifier: Modifier = Modifier,
    tmdbImageUrlProvider: TmdbImageUrlProvider,
    tvShow: TvShow,
    onClick: (tvShowId: Int) -> Unit
) {
    Card(
        elevation = 4.dp,
        modifier = modifier
            .height(280.dp)
            .width(150.dp)
            .clickable {
                onClick(tvShow.id)
            },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column {
            tvShow.posterPath?.let {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current).data(
                            tmdbImageUrlProvider.getPosterUrl(
                                path = it,
                                imageWidth = 500
                            )
                        ).apply(block = fun ImageRequest.Builder.() {
                            size(Size.ORIGINAL)
                        }).build()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.7f, fill = true)
                )
            }
            Spacer(modifier = Modifier.height(26.dp))
            tvShow.name?.let {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = it,
                    style = MaterialTheme.extendedTypography.listItem
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            tvShow.firstAirDate?.let {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = it,
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = Modifier.padding(bottom = 54.dp, start = 8.dp)
        ) {
            PopularityBadge(
                popularity = tvShow.popularityPrecentage,
            )
        }
    }
}