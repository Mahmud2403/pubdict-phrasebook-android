package com.example.phrasebook.domain.repository

import com.example.phrasebook.data.network_source.models.PhraseDetailDto
import kotlinx.coroutines.flow.Flow

interface PhraseDetailRepository {
    suspend fun getDetailPhrase(id: Int): Flow<PhraseDetailDto>
}