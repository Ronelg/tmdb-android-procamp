package com.example.moviestmdb.core.data.movies

import com.example.moviestmdb.Cast
import com.example.moviestmdb.Genere
import com.example.moviestmdb.Movie
import com.example.moviestmdb.core.data.movies.datasources.FirebaseDatabaseDataSource
import com.example.moviestmdb.core.data.movies.datasources.MoviesLocalDataSource
import com.example.moviestmdb.core.data.movies.datasources.MoviesRemoteDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private val remote: MoviesRemoteDataSource,
    private val local: MoviesLocalDataSource,
    private val firebaseDatabaseDataSource: FirebaseDatabaseDataSource
) {

    suspend fun getPopularMovies(page: Int) =
        flow {
            emit(remote.getPopularMovies(page))
        }

    fun savePopularMovies(page: Int, movies: List<Movie>) {
        local.popularMoviesStore.insert(page, movies)
    }

    fun observePopularMovies() = local.popularMoviesStore.observeEnteries()

    suspend fun getNowPlayingMovies(page: Int) =
        flow {
            emit(remote.getNowPlayingMovies(page))
        }

    fun saveNowPlayingMovies(page: Int, movies: List<Movie>) {
        local.nowPlayingMoviesStore.insert(page, movies)
    }

    fun observeNowPlayingMovies() = local.nowPlayingMoviesStore.observeEnteries()

    suspend fun getTopRatedMovies(page: Int) =
        flow {
            emit(remote.getTopRated(page))
        }

    fun saveTopRatedMovies(page: Int, movies: List<Movie>) {
        local.topRatedMoviesStore.insert(page, movies)
    }

    fun observeTopRatedMovies() = local.topRatedMoviesStore.observeEnteries()

    suspend fun getUpcomingMovies(page: Int) =
        flow {
            emit(remote.getUpcoming(page))
        }

    fun saveUpcomingMovies(page: Int, movies: List<Movie>) {
        local.upcomingMoviesStore.insert(page, movies)
    }

    fun observeUpcomingMovies() = local.upcomingMoviesStore.observeEnteries()

    suspend fun getMovieCredits(movieId: Int) =
        flow {
            emit(remote.getMovieCredits(movieId))
        }

    fun saveMovieCasts(movieId: Int, casts: List<Cast>) {
        local.castsStore.insert(movieId, casts)
    }

    suspend fun getMovieRecommendations(movieId: Int) =
        flow {
            emit(remote.getMovieRecommendations(movieId))
        }

    fun saveMovieRecommendations(movieId: Int, movies: List<Movie>) {
        local.recommendationsStore.insert(movieId.toInt(), movies)
    }

    fun addToFavourites(uid: String, movieId: Int) {
        firebaseDatabaseDataSource.addToFavourite(uid, movieId)
    }

    fun removeFromFavourite(uid: String, movieId: Int) {
        firebaseDatabaseDataSource.removeFromFavourite(uid, movieId)
    }

    fun observeFavouriteMovies() = firebaseDatabaseDataSource.observeFavouriteMovies()

    fun getGeneres() =
        flow {
            emit(remote.getGenere())
        }

    fun saveGeneres(generes: List<Genere>) = local.saveGeneres(generes)

    fun observeGeneres() = local.observeGeneres()

    fun discover(page: Int,options :Map<String, String> = emptyMap()) = flow {
        emit(remote.discover(page, options))
    }
}