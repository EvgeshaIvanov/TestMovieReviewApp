package com.example.testmoviereviewapp.domain.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("display_title")
    val title: String,
    @SerializedName("summary_short")
    val description: String,
    @SerializedName("multimedia")
    val multimedia: MultimediaModel
)
