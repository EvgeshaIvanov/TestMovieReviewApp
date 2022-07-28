package com.example.testmoviereviewapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.testmoviereviewapp.data.network.ApiService
import com.example.testmoviereviewapp.data.paging.MoviesPagingSource
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiService: ApiService) : Repository {

    override fun moviesReviews(): LiveData<PagingData<MovieModel>> {
        return Pager(
            config = PagingConfig(20),
            pagingSourceFactory = { MoviesPagingSource(apiService) }
        ).liveData
    }

}