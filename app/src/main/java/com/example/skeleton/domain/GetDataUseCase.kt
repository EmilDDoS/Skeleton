package com.example.skeleton.domain

class GetDataUseCase(private val repository: Repository) {
    suspend fun getData() = repository.getData()
}