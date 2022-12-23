package com.example.moviestmdb.core.data.tv_shows.datasources

import com.example.moviestmdb.Genere
import com.example.moviestmdb.core.data.tv_shows.TvShowsStore
import com.example.moviestmdb.core.di.TopRatedTvShows
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class TvShowsLocalDataSource @Inject constructor(
    @TopRatedTvShows val topRatedTvShowsStore: TvShowsStore,
) {

    private val _generes = MutableSharedFlow<List<Genere>>(replay = 1).apply {
        tryEmit(emptyList())
    }

    private val generes = _generes.asSharedFlow()

    fun saveGeneres(generes: List<Genere>) {
        _generes.tryEmit(generes)
    }

    //    fun observeGeneres(): SharedFlow<List<Genere>> = _generes.asSharedFlow()
    fun observeGeneres(): SharedFlow<List<Genere>> = generes
}