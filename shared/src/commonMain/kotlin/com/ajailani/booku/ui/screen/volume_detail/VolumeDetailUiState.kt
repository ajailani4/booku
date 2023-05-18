package com.ajailani.booku.ui.screen.volume_detail

import com.ajailani.booku.domain.model.VolumeInfo

data class VolumeDetailUiState(
    val loading: Boolean? = false,
    val errorMessage: String? = null,
    val volumeInfo: VolumeInfo
)
