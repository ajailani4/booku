package com.ajailani.booku.ui.screen.volume_list

import com.ajailani.booku.domain.model.Volume

data class VolumeListUiState(
    val loading: Boolean? = false,
    val errorMessage: String? = null,
    val volumes: List<Volume> = emptyList()
)
