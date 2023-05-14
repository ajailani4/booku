package com.ajailani.booku.domain.model

data class Volume(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String? = null,
    val pageCount: Int? = null,
    val averageRating: Float? = null,
    val imageLinks: ImageLinks? = null,
    val language: String
)

data class ImageLinks(
    val thumbnail: String
)
