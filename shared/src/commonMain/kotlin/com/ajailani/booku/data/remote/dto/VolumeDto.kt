package com.ajailani.booku.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class VolumeDto(
    val id: String,
    val volumeInfoDto: VolumeInfoDto
)

@Serializable
data class VolumeInfoDto(
    val title: String,
    val authors: List<String>,
    val description: String,
    val pageCount: Int,
    val imageLinksDto: ImageLinksDto
)

@Serializable
data class ImageLinksDto(
    val thumbnail: String
)
