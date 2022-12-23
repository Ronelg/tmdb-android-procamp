package com.example.moviestmdb.core.di

import javax.inject.Qualifier


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class PopularMovies

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class TopRatedMovies

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class TopRatedTvShows

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class UpcomingMovies

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class NowPlayingMovies

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
@MustBeDocumented
annotation class ApplicationScope