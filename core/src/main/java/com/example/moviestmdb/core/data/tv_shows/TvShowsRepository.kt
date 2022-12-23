package com.example.moviestmdb.core.data.tv_shows

import com.example.moviestmdb.TvShow
import com.example.moviestmdb.core.data.tv_shows.datasources.TvShowsLocalDataSource
import com.example.moviestmdb.core.data.tv_shows.datasources.TvShowsRemoteDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowsRepository @Inject constructor(
    private val remote: TvShowsRemoteDataSource,
    private val local: TvShowsLocalDataSource
) {

    suspend fun getTopRatedTvShows(page: Int) =
        flow {
            emit(remote.getTopRated(page))
        }

    fun saveTopRatedTvShows(page: Int, tvShows: List<TvShow>) {
        local.topRatedTvShowsStore.insert(page, tvShows)
    }

    fun observeTopRatedTvShows() = local.topRatedTvShowsStore.observeEnteries()


    suspend fun getPopularTvShows(page: Int) =
        flow {
            emit(remote.getPopular(page))
        }

    fun savePopularTvShows(page: Int, tvShows: List<TvShow>) {
        local.popularTvShowsStore.insert(page, tvShows)
    }

    fun observePopularTvShows() = local.popularTvShowsStore.observeEnteries()
}