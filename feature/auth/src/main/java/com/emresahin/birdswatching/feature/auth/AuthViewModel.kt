package com.emresahin.birdswatching.feature.auth

import androidx.lifecycle.viewModelScope
import com.emresahin.birdswatching.core.auth.repository.AuthRepository
import com.emresahin.birdswatching.core.common.base.BaseViewModel
import com.emresahin.birdswatching.core.common.base.UiEvent
import com.emresahin.birdswatching.core.model.auth.UserInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : BaseViewModel<AuthEvent>() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onEvent(event: AuthEvent.Action) {
        when (event) {
            is AuthEvent.Action.UpdateEmail -> {
                _uiState.value = _uiState.value.copy(email = event.email)
            }
            is AuthEvent.Action.UpdatePassword -> {
                _uiState.value = _uiState.value.copy(password = event.password)
            }
            is AuthEvent.Action.UpdateName -> {
                _uiState.value = _uiState.value.copy(name = event.name)
            }
            AuthEvent.Action.Login -> login()
            AuthEvent.Action.Register -> register()
        }
    }

    private fun login() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val result = authRepository.login(
                email = _uiState.value.email,
                password = _uiState.value.password
            )
            _uiState.value = _uiState.value.copy(isLoading = false)

            if (result.isSuccess) {
                sendEvent(AuthEvent.NavigateToHome)
            } else {
                sendEvent(AuthEvent.ShowError(result.errorMessage ?: "An error occurred"))
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val result = authRepository.register(
                name = _uiState.value.name,
                email = _uiState.value.email,
                password = _uiState.value.password
            )
            _uiState.value = _uiState.value.copy(isLoading = false)

            if (result.isSuccess) {
                sendEvent(AuthEvent.NavigateToHome)
            } else {
                sendEvent(AuthEvent.ShowError(result.errorMessage ?: "An error occurred"))
            }
        }
    }
}

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val name: String = "",
    val isLoading: Boolean = false,
    val user: UserInfo? = null
)

sealed interface AuthEvent : UiEvent {
    sealed interface Action {
        data class UpdateEmail(val email: String) : Action
        data class UpdatePassword(val password: String) : Action
        data class UpdateName(val name: String) : Action
        data object Login : Action
        data object Register : Action
    }

    data object NavigateToHome : AuthEvent
    data class ShowError(val message: String) : AuthEvent
} 