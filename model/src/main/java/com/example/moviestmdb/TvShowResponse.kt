package com.example.moviestmdb

import com.google.gson.annotations.SerializedName

data class TvShowResponse (
    @SerializedName("page")
    val page : Int = 0,
    @SerializedName("results")
    val tvShowList: List<TvShow> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)