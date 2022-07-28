package com.example.testmoviereviewapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase

class MoviesViewModelFactory(private val useCase: MoviesReviewsUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }
}