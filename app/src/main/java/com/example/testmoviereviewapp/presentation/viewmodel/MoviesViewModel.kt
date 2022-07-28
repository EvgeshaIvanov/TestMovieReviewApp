package com.example.testmoviereviewapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesReviewsUseCase: MoviesReviewsUseCase) : ViewModel() {


    val moviesLiveData = MutableLiveData<List<MovieModel>>()

    fun moviesReviews() {
        viewModelScope.launch {
            val list = moviesReviewsUseCase.execute()
            moviesLiveData.postValue(list)
        }
    }

}