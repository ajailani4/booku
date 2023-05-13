package com.ajailani.booku.domain.model

data class Volume(
    val id: String,
    val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    val authors: List<String>,
    val description: String,
    val pageCount: Int,
    val imageLinks: ImageLinks
)

data class ImageLinks(
    val thumbnail: String
)
