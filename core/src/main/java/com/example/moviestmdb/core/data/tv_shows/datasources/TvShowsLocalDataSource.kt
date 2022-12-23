package com.example.moviestmdb.core.data.tv_shows.datasources

import com.example.moviestmdb.core.data.tv_shows.TvShowsStore
import com.example.moviestmdb.core.di.PopularsTvShows
import com.example.moviestmdb.core.di.TopRatedTvShows
import javax.inject.Inject

class TvShowsLocalDataSource @Inject constructor(
    @TopRatedTvShows val topRatedTvShowsStore: TvShowsStore,
    @PopularsTvShows val popularTvShowsStore: TvShowsStore,
) {

}