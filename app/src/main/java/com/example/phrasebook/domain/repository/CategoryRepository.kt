package com.example.phrasebook.domain.repository

import com.example.phrasebook.data.network_source.models.CategoryDto
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun getCategories(): Flow<CategoryDto>
}