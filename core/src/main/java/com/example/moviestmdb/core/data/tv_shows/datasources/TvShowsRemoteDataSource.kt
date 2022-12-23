package com.example.moviestmdb.core.data.tv_shows.datasources

import com.example.moviestmdb.TvShowResponse
import com.example.moviestmdb.core.extensions.executeWithRetry
import com.example.moviestmdb.core.extensions.toResult
import com.example.moviestmdb.core.network.TvShowsService
import com.example.moviestmdb.core.result.Result
import com.example.moviestmdb.core.util.safeApiCall
import javax.inject.Inject


class TvShowsRemoteDataSource @Inject constructor(
    private val tvShowsService: TvShowsService
) {

    suspend fun getTopRated(page: Int): Result<TvShowResponse> {
        return safeApiCall {
            tvShowsService
                .getTopRated(page)
                .executeWithRetry()
                .toResult()
        }
    }

}