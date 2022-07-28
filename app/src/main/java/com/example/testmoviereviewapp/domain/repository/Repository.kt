package com.example.testmoviereviewapp.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.testmoviereviewapp.domain.model.MovieModel

interface Repository {

    fun moviesReviews(): LiveData<PagingData<MovieModel>>

}
