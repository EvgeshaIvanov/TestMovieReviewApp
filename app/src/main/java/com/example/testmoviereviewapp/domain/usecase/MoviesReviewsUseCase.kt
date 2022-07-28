package com.example.testmoviereviewapp.domain.usecase

import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.repository.Repository

class MoviesReviewsUseCase(private val repository: Repository) {

    suspend fun execute(): List<MovieModel> = repository.moviesReviews()

}