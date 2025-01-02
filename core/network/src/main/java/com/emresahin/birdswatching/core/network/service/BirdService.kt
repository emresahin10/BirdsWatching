package com.emresahin.birdswatching.core.network.service

import com.emresahin.birdswatching.core.model.bird.Bird
import retrofit2.http.GET
import retrofit2.http.Header

interface BirdService {
    @GET("birds")
    suspend fun getBirds(
        @Header("Authorization") authorization: String
    ): List<Bird>
} 