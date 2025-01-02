package com.emresahin.birdswatching.core.model.auth

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String
)

@Serializable
data class RegisterRequest(
    @SerialName("email")
    val email: String,
    @SerialName("passwordHash")
    val password: String,
    @SerialName("name")
    val name: String
)

@Serializable
data class LoginResponse(
    @SerialName("accessToken")
    val accessToken: String,
    @SerialName("refreshToken")
    val refreshToken: String,
    @SerialName("user")
    val user: UserInfo
)

@Serializable
data class RefreshTokenRequest(
    @SerialName("refreshToken")
    val refreshToken: String
)

@Serializable
data class RefreshTokenResponse(
    @SerialName("token")
    val accessToken: String
)

@Serializable
data class UserInfo(
    @SerialName("id")
    val id: UserId,
    @SerialName("email")
    val email: String,
    @SerialName("passwordHash")
    val passwordHash: String,
    @SerialName("name")
    val name: String,
    @SerialName("refreshToken")
    val refreshToken: String?,
    @SerialName("refreshTokenExpiresAt")
    val refreshTokenExpiresAt: Long?,
    @SerialName("createdAt")
    val createdAt: Long,
    @SerialName("updatedAt")
    val updatedAt: Long
)

@Serializable
data class UserId(
    @SerialName("timestamp")
    val timestamp: Long,
    @SerialName("date")
    val date: String
)

@Serializable
data class AuthResult(
    val isSuccess: Boolean,
    val errorMessage: String? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val user: UserInfo? = null
) 