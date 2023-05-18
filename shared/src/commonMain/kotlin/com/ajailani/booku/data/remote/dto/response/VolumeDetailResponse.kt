package com.ajailani.booku.data.remote.dto.response

import com.ajailani.booku.data.remote.dto.VolumeInfoDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeDetailResponse(
    val kind: String,
    val id: String,
    @SerialName("volumeInfo")
    val volumeInfoDto: VolumeInfoDto
)
