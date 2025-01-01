package com.emresahin.birdswatching.core.auth.repository

import com.emresahin.birdswatching.core.auth.manager.TokenManager
import com.emresahin.birdswatching.core.model.auth.AuthResult
import com.emresahin.birdswatching.core.model.auth.LoginRequest
import com.emresahin.birdswatching.core.model.auth.RefreshTokenRequest
import com.emresahin.birdswatching.core.model.auth.RegisterRequest
import com.emresahin.birdswatching.core.network.api.AuthService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val tokenManager: TokenManager
) : AuthRepository {
    override val accessToken: Flow<String?> = tokenManager.accessToken
    override val refreshToken: Flow<String?> = tokenManager.refreshToken

    override suspend fun login(email: String, password: String): AuthResult {
        return try {
            val response = authService.login(LoginRequest(email, password))
            tokenManager.saveTokens(response.accessToken, response.refreshToken)
            AuthResult(
                isSuccess = true,
                accessToken = response.accessToken,
                refreshToken = response.refreshToken,
                user = response.user
            )
        } catch (e: Exception) {
            AuthResult(
                isSuccess = false,
                errorMessage = e.message ?: "An error occurred during login"
            )
        }
    }

    override suspend fun register(name: String, email: String, password: String): AuthResult {
        return try {
            val user = authService.register(
                RegisterRequest(
                    email = email,
                    password = password,
                    name = name
                )
            )
            AuthResult(
                isSuccess = true,
                user = user
            )
        } catch (e: Exception) {
            AuthResult(
                isSuccess = false,
                errorMessage = e.message ?: "An error occurred during registration"
            )
        }
    }

    override suspend fun refreshToken(): AuthResult {
        return try {
            val currentRefreshToken = refreshToken.first() ?: throw Exception("No refresh token found")
            val response = authService.refreshToken(RefreshTokenRequest(currentRefreshToken))
            tokenManager.updateAccessToken(response.accessToken)
            AuthResult(
                isSuccess = true,
                accessToken = response.accessToken
            )
        } catch (e: Exception) {
            AuthResult(
                isSuccess = false,
                errorMessage = e.message ?: "An error occurred during token refresh"
            )
        }
    }

    override suspend fun logout() {
        tokenManager.clearTokens()
    }
} 