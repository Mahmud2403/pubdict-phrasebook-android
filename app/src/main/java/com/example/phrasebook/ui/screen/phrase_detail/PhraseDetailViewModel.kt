package com.example.phrasebook.ui.screen.phrase_detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phrasebook.data.network_source.collectAsResult
import com.example.phrasebook.data.network_source.models.PhraseDetailDto
import com.example.phrasebook.data.network_source.models.toDetail
import com.example.phrasebook.domain.models.PhraseDetail
import com.example.phrasebook.domain.repository.PhraseDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhraseDetailViewModel @Inject constructor(
    private val phraseDetailRepository: PhraseDetailRepository
): ViewModel() {
    private var _phraseDetailUiState = MutableStateFlow(PhraseDetailUiState())
    val phraseDetailUiState = _phraseDetailUiState.asStateFlow()

    fun getDetailPhrase(id: Int) {
        viewModelScope.launch {
            phraseDetailRepository.getDetailPhrase(id).collectAsResult(
                onSuccess = {
                    _phraseDetailUiState.update { currentState ->
                        currentState.copy(
                            phraseDetail = it.toDetail()
                        )
                    }
                    Log.e("phrasedetail", "$it")
                }
            )
        }
    }

}

data class PhraseDetailUiState(
    val phraseDetail: PhraseDetail = PhraseDetail.mockData,
)