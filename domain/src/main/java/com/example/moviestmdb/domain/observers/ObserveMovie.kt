package com.example.moviestmdb.domain.observers

import com.example.moviestmdb.Movie
import com.example.moviestmdb.core.data.movies.MoviesRepository
import com.example.moviestmdb.core.data.movies.MoviesStore
import com.example.moviestmdb.core.di.NowPlayingMovies
import com.example.moviestmdb.core.di.PopularMovies
import com.example.moviestmdb.core.di.TopRatedMovies
import com.example.moviestmdb.core.di.UpcomingMovies
import com.example.moviestmdb.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ObserveMovie @Inject constructor(
    private val moviesRepository: MoviesRepository,
    @PopularMovies private val popularMoviesStore: MoviesStore,
    @TopRatedMovies private val topRatedMoviesStore: MoviesStore,
    @UpcomingMovies private val upcomingMoviesStore: MoviesStore,
    @NowPlayingMovies private val nowPlayingMoviesStore: MoviesStore,
) : SubjectInteractor<ObserveMovie.Params, Movie>() {

    override fun createObservable(params: Params): Flow<Movie> {
        return combine(
            popularMoviesStore.observeMovies(),
            topRatedMoviesStore.observeMovies(),
            upcomingMoviesStore.observeMovies(),
            nowPlayingMoviesStore.observeMovies(),
        ) { popular, topRated, upcoming, nowPlaying ->
            val list = mutableListOf<Movie>()
            list.addAll(popular)
            list.addAll(topRated)
            list.addAll(upcoming)
            list.addAll(nowPlaying)
            list
        }
            .map {
                it.first { it.id == params.movieId }
            }
    }

    data class Params(val movieId: Int)

}