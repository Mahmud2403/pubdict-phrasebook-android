package com.example.phrasebook.ui.screen.phrase_category

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PhraseCategoryViewModel @Inject constructor(

): ViewModel() {
    private var _phraseCategoryUiState = MutableStateFlow(PhraseCategoryUiState())
    val phraseCategoryUiState = _phraseCategoryUiState.asStateFlow()

    fun setFavourite(isFavourite: Boolean) {
        when (isFavourite) {
            true -> unsetFavorite()
            false -> addFavorite()
        }
        Log.e("aaaaa", "$isFavourite")
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
    val isFavorite: Boolean = true,
)