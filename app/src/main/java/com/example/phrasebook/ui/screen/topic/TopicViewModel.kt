package com.example.phrasebook.ui.screen.topic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phrasebook.data.network_source.collectAsResult
import com.example.phrasebook.data.network_source.models.CategoryDto
import com.example.phrasebook.domain.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {
    private var _topicUiState = MutableStateFlow(TopicUiState())
    val topicUiState = _topicUiState.asStateFlow()

    init {
        getTopic()
    }

    fun getTopic() {
        viewModelScope.launch {
            categoryRepository.getCategories().collectAsResult(
                onSuccess = {
                    _topicUiState.update { currentState ->
                        currentState.copy(
                            categoryList = it
                        )
                    }
                }
            )
        }
    }
}

data class TopicUiState(
    val categoryList: CategoryDto? = null
)