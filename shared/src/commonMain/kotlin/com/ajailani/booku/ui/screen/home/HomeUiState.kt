package com.ajailani.booku.ui.screen.home

import com.ajailani.booku.domain.model.Volume

data class HomeUiState(
    val loading: Boolean? = false,
    val errorMessage: String? = null,
    val fictionVolumes: List<Volume> = emptyList(),
    val scienceVolumes: List<Volume> = emptyList(),
    val technologyVolumes: List<Volume> = emptyList(),
    val socialVolumes: List<Volume> = emptyList(),
    val businessVolumes: List<Volume> = emptyList()
)
