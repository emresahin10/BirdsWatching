package com.emresahin.birdswatching.core.data.repository

import com.emresahin.birdswatching.core.common.Result
import com.emresahin.birdswatching.core.data.auth.AuthManager
import com.emresahin.birdswatching.core.domain.repository.BirdRepository
import com.emresahin.birdswatching.core.model.bird.Bird
import com.emresahin.birdswatching.core.network.service.BirdService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BirdRepositoryImpl @Inject constructor(
    private val birdService: BirdService,
    private val authManager: AuthManager
) : BirdRepository {

    override fun getBirds(): Flow<Result<List<Bird>>> = flow {
        emit(Result.Loading)
        try {
            val token = authManager.getAccessToken()
            val birds = birdService.getBirds("Bearer $token")
            emit(Result.Success(birds))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
} 