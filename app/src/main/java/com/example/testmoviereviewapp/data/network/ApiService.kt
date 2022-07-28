package com.example.testmoviereviewapp.data.network

import com.example.testmoviereviewapp.data.model.ResponseMovieModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("svc/movies/v2/reviews/all.json?api-key=iyo1GlBaVN2AjrpB6uRFcTQzgO4ja4pN")
    suspend fun moviesReviews(@Query("offset") page: Int): ResponseMovieModel

}