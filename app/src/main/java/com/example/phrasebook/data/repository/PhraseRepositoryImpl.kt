package com.example.phrasebook.data.repository

import com.example.phrasebook.data.network_source.PhrasebookApi
import com.example.phrasebook.data.network_source.models.PhraseDto
import com.example.phrasebook.domain.repository.PhraseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhraseRepositoryImpl @Inject constructor(
    private val api: PhrasebookApi
): PhraseRepository {
    override suspend fun getPhrase(id: Int): Flow<PhraseDto> = flow {
        emit(api.getPhrases(id))
    }

}