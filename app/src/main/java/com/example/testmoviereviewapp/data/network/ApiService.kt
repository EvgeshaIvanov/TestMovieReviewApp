package com.example.testmoviereviewapp.data.network

import com.example.testmoviereviewapp.data.model.ResponseMovieModel
import com.example.testmoviereviewapp.utils.Constants.REVIEWS_URL
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(REVIEWS_URL)
    suspend fun moviesReviews(@Query("offset") page: Int): ResponseMovieModel

}