package com.example.skeleton.domain

import com.example.skeleton.domain.model.PhotoItemModel

interface Repository {
    suspend fun getData(): List<PhotoItemModel>
}