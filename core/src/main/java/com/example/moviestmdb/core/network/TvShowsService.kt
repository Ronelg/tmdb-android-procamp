package com.example.moviestmdb.core.network

import com.example.moviestmdb.MovieResponse
import com.example.moviestmdb.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowsService {


    @GET("tv/top_rated")
    fun getTopRated(
        @Query("page") page: Int
    ): Call<TvShowResponse>


}