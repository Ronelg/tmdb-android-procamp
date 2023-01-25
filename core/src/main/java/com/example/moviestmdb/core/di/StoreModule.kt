package com.example.moviestmdb.core.di

import com.example.moviestmdb.core.data.movies.MoviesStore
import com.example.moviestmdb.core.data.tv_shows.TvShowsStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class StoreModule {

    @Singleton
    @Provides
    @PopularMovies
    fun providePopularStore(): MoviesStore = MoviesStore()

    @Singleton
    @Provides
    @NowPlayingMovies
    fun provideNowPlayingStore(): MoviesStore = MoviesStore()

    @Singleton
    @Provides
    @UpcomingMovies
    fun provideUpcomingStore(): MoviesStore = MoviesStore()

    @Singleton
    @Provides
    @TopRatedMovies
    fun provideTopRatedMoviesStore(): MoviesStore = MoviesStore()

    @Singleton
    @Provides
    @TopRatedTvShows
    fun provideTopRatedTvShowsStore(): TvShowsStore = TvShowsStore()

    @Singleton
    @Provides
    @PopularsTvShows
    fun providePopularTvShowsStore(): TvShowsStore = TvShowsStore()
}