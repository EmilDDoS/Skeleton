package com.example.skeleton.di

import com.example.skeleton.data.RepositoryImpl
import com.example.skeleton.data.mapper.Mapper
import com.example.skeleton.data.network.ApiFactory
import com.example.skeleton.domain.GetDataUseCase
import com.example.skeleton.domain.Repository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetDataUseCase(
        repository: Repository
    ) = GetDataUseCase(repository)

    @Provides
    fun provideRepository(
        apiFactory: ApiFactory,
        mapper: Mapper
    ): Repository = RepositoryImpl(apiFactory, mapper)
}