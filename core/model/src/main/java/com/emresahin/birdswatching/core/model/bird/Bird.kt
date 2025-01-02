package com.emresahin.birdswatching.core.model.bird

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bird(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("scientificName")
    val scientificName: String,
    @SerialName("habitat")
    val habitat: List<String>,
    @SerialName("photoUrl")
    val photoUrl: String,
    @SerialName("description")
    val description: String,
    @SerialName("createdAt")
    val createdAt: Long,
    @SerialName("updatedAt")
    val updatedAt: Long
) 