package com.example.skeleton.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skeleton.domain.GetDataUseCase
import com.example.skeleton.domain.model.PhotoItemModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotosViewModel(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _photosData = MutableStateFlow(listOf<PhotoItemModel>())
    val photosData: StateFlow<List<PhotoItemModel>>
        get() = _photosData.asStateFlow()

    fun getData(){
        viewModelScope.launch {
            try {
                val result = getDataUseCase.getData()
                _photosData.tryEmit(result)
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}