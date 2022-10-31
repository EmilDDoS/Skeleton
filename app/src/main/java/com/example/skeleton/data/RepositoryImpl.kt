package com.example.skeleton.data

import com.example.skeleton.data.mapper.Mapper
import com.example.skeleton.data.network.ApiFactory
import com.example.skeleton.domain.Repository
import com.example.skeleton.domain.model.PhotoItemModel

class RepositoryImpl(
    private val apiFactory: ApiFactory,
    private val mapper: Mapper
): Repository {
    override suspend fun getData(): List<PhotoItemModel> {
        val result = apiFactory.instance.getPhotosApi()
        return result.map { mapper.mapPhotoItemDtoToPhotoItemModel(it) }
    }
}