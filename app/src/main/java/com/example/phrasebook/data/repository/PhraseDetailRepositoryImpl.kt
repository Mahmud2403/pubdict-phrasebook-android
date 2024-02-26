package com.example.phrasebook.data.repository

import com.example.phrasebook.data.network_source.PhrasebookApi
import com.example.phrasebook.data.network_source.models.PhraseDetailDto
import com.example.phrasebook.domain.repository.PhraseDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhraseDetailRepositoryImpl @Inject constructor(
    private val api: PhrasebookApi
): PhraseDetailRepository {
    override suspend fun getDetailPhrase(id: Int): Flow<PhraseDetailDto> = flow {
        emit(
            api.getDetailPhrase(id = id)
        )
    }
}