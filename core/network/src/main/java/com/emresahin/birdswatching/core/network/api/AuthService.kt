package com.emresahin.birdswatching.core.network.api

import com.emresahin.birdswatching.core.model.auth.LoginRequest
import com.emresahin.birdswatching.core.model.auth.LoginResponse
import com.emresahin.birdswatching.core.model.auth.RefreshTokenRequest
import com.emresahin.birdswatching.core.model.auth.RefreshTokenResponse
import com.emresahin.birdswatching.core.model.auth.RegisterRequest
import com.emresahin.birdswatching.core.model.auth.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("users/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    @POST("users/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): UserInfo

    @POST("users/refresh")
    suspend fun refreshToken(
        @Body request: RefreshTokenRequest
    ): RefreshTokenResponse
} 