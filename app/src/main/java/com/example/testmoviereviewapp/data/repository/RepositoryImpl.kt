package com.example.testmoviereviewapp.data.repository

import com.example.testmoviereviewapp.data.network.RetrofitInstance
import com.example.testmoviereviewapp.domain.model.MovieModel
import com.example.testmoviereviewapp.domain.repository.Repository

class RepositoryImpl : Repository {

    override suspend fun moviesReviews(): List<MovieModel> {
        return RetrofitInstance.api.moviesReviews().movieModel
    }
}