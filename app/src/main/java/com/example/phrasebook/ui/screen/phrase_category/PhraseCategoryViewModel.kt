package com.example.phrasebook.ui.screen.phrase_category

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phrasebook.data.network_source.collectAsResult
import com.example.phrasebook.data.network_source.models.PhraseDto
import com.example.phrasebook.domain.repository.PhraseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhraseCategoryViewModel @Inject constructor(
    private val phraseRepository: PhraseRepository
): ViewModel() {
    private var _phraseCategoryUiState = MutableStateFlow(PhraseCategoryUiState())
    val phraseCategoryUiState = _phraseCategoryUiState.asStateFlow()


    fun getPhrase(id: Int) {
        viewModelScope.launch {
            phraseRepository.getPhrase(id).collectAsResult(
                onSuccess = {
                    _phraseCategoryUiState.update { currentState ->
                        currentState.copy(
                            phrase = it
                        )
                    }
                }
            )
        }
    }

    fun setFavourite(isFavourite: Boolean) {
        when (isFavourite) {
            true -> unsetFavorite()
            false -> addFavorite()
        }
    }
    private fun addFavorite() {
        _phraseCategoryUiState.update { currentState ->
            currentState.copy(
                isFavorite = false
            )
        }
    }

    private fun unsetFavorite() {
        _phraseCategoryUiState.update { currentState ->
            currentState.copy(
                isFavorite = true
            )
        }
    }
}

data class PhraseCategoryUiState(
    val phrase: PhraseDto? = null,
    val isFavorite: Boolean = true,
)