package com.example.testmoviereviewapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase

class MoviesViewModel(moviesReviewsUseCase: MoviesReviewsUseCase) : ViewModel() {

    val moviesList: LiveData<PagingData<MovieModel>> =
        moviesReviewsUseCase.execute().cachedIn(viewModelScope)

}