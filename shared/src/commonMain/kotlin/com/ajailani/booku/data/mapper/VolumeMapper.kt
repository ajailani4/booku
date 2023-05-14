package com.ajailani.booku.data.mapper

import com.ajailani.booku.data.remote.dto.ImageLinksDto
import com.ajailani.booku.data.remote.dto.VolumeDto
import com.ajailani.booku.data.remote.dto.VolumeInfoDto
import com.ajailani.booku.domain.model.ImageLinks
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.model.VolumeInfo

fun VolumeDto.toVolume() =
    Volume(
        id = id,
        volumeInfo = volumeInfoDto.toVolumeInfo()
    )

fun VolumeInfoDto.toVolumeInfo() =
    VolumeInfo(
        title = title,
        authors = authors,
        description = description,
        pageCount = pageCount,
        averageRating = averageRating,
        imageLinks = imageLinksDto?.toImageLinks(),
        language = language
    )

fun ImageLinksDto.toImageLinks() =
    ImageLinks(
        thumbnail = thumbnail
    )