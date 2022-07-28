package com.example.testmoviereviewapp.utils

import com.example.testmoviereviewapp.BuildConfig

object Constants {

    const val BASE_URL = "https://api.nytimes.com/"

    const val REVIEWS_URL =
        "svc/movies/v2/reviews/all.json?api-key=${BuildConfig.API_KEY}"

    const val PAGE = 0

    const val MOVIES_ITEMS = 20
}