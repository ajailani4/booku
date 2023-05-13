package com.ajailani.booku.data.remote.dto.response

import com.ajailani.booku.data.remote.dto.VolumeDto
import kotlinx.serialization.Serializable

@Serializable
data class VolumeResponse(
    val kind: String,
    val items: List<VolumeDto>
)
