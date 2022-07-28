package com.example.testmoviereviewapp.di

import com.example.testmoviereviewapp.domain.usecase.MoviesReviewsUseCase
import com.example.testmoviereviewapp.presentation.viewmodel.MoviesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    fun provideMoviesViewModelFactory(moviesReviewsUseCase: MoviesReviewsUseCase): MoviesViewModelFactory {
        return MoviesViewModelFactory(moviesReviewsUseCase = moviesReviewsUseCase)
    }
}


