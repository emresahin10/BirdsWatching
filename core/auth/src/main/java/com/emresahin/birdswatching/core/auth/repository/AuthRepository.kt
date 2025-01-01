package com.emresahin.birdswatching.core.auth.repository

import com.emresahin.birdswatching.core.model.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val accessToken: Flow<String?>
    val refreshToken: Flow<String?>

    suspend fun login(email: String, password: String): AuthResult
    suspend fun register(name: String, email: String, password: String): AuthResult
    suspend fun refreshToken(): AuthResult
    suspend fun logout()
} 