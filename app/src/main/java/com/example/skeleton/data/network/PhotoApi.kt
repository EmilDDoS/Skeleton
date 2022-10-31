package com.example.skeleton.data.network

import com.example.skeleton.data.entity.PhotoItemDto
import retrofit2.http.GET

interface PhotoApi {
        @GET("photos")
        suspend fun getPhotosApi(): List<PhotoItemDto>
}