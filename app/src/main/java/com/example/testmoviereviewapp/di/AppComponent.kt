package com.example.testmoviereviewapp.di

import com.example.testmoviereviewapp.presentation.MainActivity
import dagger.Component


@Component(modules = [DomainModule::class, DataModule::class, AppModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}