package com.example.testmoviereviewapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase

class MoviesViewModelFactory(private val moviesReviewsUseCase: MoviesReviewsUseCase) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(
                moviesReviewsUseCase = moviesReviewsUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}