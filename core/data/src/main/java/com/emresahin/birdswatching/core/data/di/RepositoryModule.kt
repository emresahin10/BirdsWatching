package com.emresahin.birdswatching.core.data.di

import com.emresahin.birdswatching.core.data.repository.BirdRepositoryImpl
import com.emresahin.birdswatching.core.domain.repository.BirdRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    
    @Binds
    @Singleton
    fun bindBirdRepository(
        birdRepositoryImpl: BirdRepositoryImpl
    ): BirdRepository
} 