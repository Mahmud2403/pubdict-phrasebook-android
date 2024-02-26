package com.example.phrasebook.data.repository

import com.example.phrasebook.data.network_source.PhrasebookApi
import com.example.phrasebook.data.network_source.models.CategoryDto
import com.example.phrasebook.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: PhrasebookApi
): CategoryRepository {
    override suspend fun getCategories(): Flow<CategoryDto>  = flow {
        emit(
            api.getCategories()
        )
    }

}