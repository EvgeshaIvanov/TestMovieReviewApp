package com.example.testmoviereviewapp.di

import com.example.testmoviereviewapp.data.network.ApiService
import com.example.testmoviereviewapp.data.network.RetrofitInstance
import com.example.testmoviereviewapp.data.repository.RepositoryImpl
import com.example.testmoviereviewapp.domain.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiService(): ApiService {
        return RetrofitInstance.api
    }

    @Provides
    fun provideRepositoryImpl(apiService: ApiService): Repository {
        return RepositoryImpl(apiService = apiService)
    }


}