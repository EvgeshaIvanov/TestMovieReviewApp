package com.example.testmoviereviewapp.data.model

import com.example.testmoviereviewapp.domain.model.MovieModel
import com.google.gson.annotations.SerializedName

data class ResponseMovieModel(
    @SerializedName("results")
    val movieModel: List<MovieModel>
)
