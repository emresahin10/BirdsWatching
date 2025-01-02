package com.emresahin.birdswatching.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emresahin.birdswatching.core.common.Result
import com.emresahin.birdswatching.core.domain.repository.BirdRepository
import com.emresahin.birdswatching.core.model.bird.Bird
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = false,
    val birds: List<Bird> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val birdRepository: BirdRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        fetchBirds()
    }

    fun fetchBirds() {
        viewModelScope.launch {
            birdRepository.getBirds().collect { result ->
                _uiState.update {
                    when (result) {
                        is Result.Loading -> it.copy(isLoading = true)
                        is Result.Success -> it.copy(
                            isLoading = false,
                            birds = result.data,
                            error = null
                        )
                        is Result.Error -> it.copy(
                            isLoading = false,
                            error = result.exception.message
                        )
                    }
                }
            }
        }
    }
} 