package com.example.testmoviereviewapp.domain.repository

import com.example.testmoviereviewapp.domain.model.MovieModel

interface Repository {

    suspend fun moviesReviews(page: Int): List<MovieModel>

}
