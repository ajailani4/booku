package com.ajailani.booku.ui.screen.volume_list

import com.ajailani.booku.domain.model.Volume

data class VolumeListUiState(
    val loading: Boolean? = null,
    val errorMessage: String? = null,
    val volumes: List<Volume>? = listOf()
)
