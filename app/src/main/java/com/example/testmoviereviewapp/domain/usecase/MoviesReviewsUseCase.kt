package com.example.testmoviereviewapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.repository.Repository

class MoviesReviewsUseCase(private val repository: Repository) {

    fun execute(): LiveData<PagingData<MovieModel>> = repository.moviesReviews()

}