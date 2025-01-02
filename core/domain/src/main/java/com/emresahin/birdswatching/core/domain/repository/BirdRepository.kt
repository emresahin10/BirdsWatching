package com.emresahin.birdswatching.core.domain.repository

import com.emresahin.birdswatching.core.model.bird.Bird
import com.emresahin.birdswatching.core.common.Result
import kotlinx.coroutines.flow.Flow

interface BirdRepository {
    fun getBirds(): Flow<Result<List<Bird>>>
} 