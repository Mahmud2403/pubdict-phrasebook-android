package com.example.phrasebook.domain.repository

import com.example.phrasebook.data.network_source.models.PhraseDto
import kotlinx.coroutines.flow.Flow

interface PhraseRepository {
    suspend fun getPhrase(id: Int): Flow<PhraseDto>
}