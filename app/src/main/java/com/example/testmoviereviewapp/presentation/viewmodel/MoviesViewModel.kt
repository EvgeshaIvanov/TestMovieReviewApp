package com.example.testmoviereviewapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.testmoviereviewapp.data.repository.RepositoryImpl
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase
import com.example.testmoviereviewapp.presentation.paging.MoviesPagingSource

class MoviesViewModel : ViewModel() {

    private val repositoryImpl = RepositoryImpl()

    private val moviesReviewsUseCase = MoviesReviewsUseCase(repositoryImpl)

    val flow = Pager(PagingConfig(pageSize = 20)) { MoviesPagingSource(moviesReviewsUseCase) }
        .flow
        .cachedIn(viewModelScope)

}