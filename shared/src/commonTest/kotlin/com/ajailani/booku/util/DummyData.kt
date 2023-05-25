package com.ajailani.booku.util

import com.ajailani.booku.domain.model.ImageLinks
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.domain.model.VolumeInfo

object DummyData {
    val volume = Volume(
        id = "1",
        volumeInfo = VolumeInfo(
            title = "Test",
            authors = listOf("George Zayvich"),
            description = "This is a book",
            pageCount = 100,
            averageRating = 4.5f,
            imageLinks = ImageLinks(thumbnail = "https://image.com"),
            language = "en"
        )
    )

    val volumes = listOf(volume, volume)
}