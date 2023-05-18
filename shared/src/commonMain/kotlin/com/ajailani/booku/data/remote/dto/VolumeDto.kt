package com.ajailani.booku.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeDto(
    val id: String,
    @SerialName("volumeInfo")
    val volumeInfoDto: VolumeInfoDto
)

@Serializable
data class VolumeInfoDto(
    val title: String,
    val authors: List<String>? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    val averageRating: Float? = null,
    @SerialName("imageLinks")
    val imageLinksDto: ImageLinksDto? = null,
    val language: String
)

@Serializable
data class ImageLinksDto(
    val thumbnail: String
)
