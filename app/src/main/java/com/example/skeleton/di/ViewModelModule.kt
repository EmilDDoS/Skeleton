package com.example.skeleton.di

import androidx.lifecycle.ViewModel
import com.example.skeleton.domain.GetDataUseCase
import com.example.skeleton.presentation.PhotosViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {

    @IntoMap
    @ClassKey(PhotosViewModel::class)
    @Provides
    fun getViewModel(
        getDataUseCase: GetDataUseCase
    ): ViewModel = PhotosViewModel(getDataUseCase)
}