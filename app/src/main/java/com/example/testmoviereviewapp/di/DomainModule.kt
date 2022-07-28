package com.example.testmoviereviewapp.di

import com.example.testmoviereviewapp.domain.repository.Repository
import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun provideMoviesReviewsUseCase(repository: Repository): MoviesReviewsUseCase {
        return MoviesReviewsUseCase(repository = repository)
    }

}