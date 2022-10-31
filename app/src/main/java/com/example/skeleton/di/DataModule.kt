package com.example.skeleton.di

import com.example.skeleton.data.mapper.Mapper
import com.example.skeleton.data.network.ApiFactory
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideApiFactory() = ApiFactory()

    @Provides
    fun provideMapper() = Mapper()
}