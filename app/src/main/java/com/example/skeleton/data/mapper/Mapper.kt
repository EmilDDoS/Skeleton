package com.example.skeleton.data.mapper

import com.example.skeleton.data.entity.PhotoItemDto
import com.example.skeleton.domain.model.PhotoItemModel

class Mapper {
    fun mapPhotoItemDtoToPhotoItemModel(photoItemDto: PhotoItemDto) = PhotoItemModel(
        id = photoItemDto.id,
        thumbnailUrl = photoItemDto.thumbnailUrl,
        title = photoItemDto.title,
        url = photoItemDto.url
    )
}