package com.ajailani.booku.ui.screen.home

import com.ajailani.booku.domain.model.Volume

data class HomeUiState(
    val loading: Boolean? = null,
    val errorMessage: String? = null,
    val fictionVolumes: List<Volume>? = listOf(),
    val scienceVolumes: List<Volume>? = listOf(),
    val technologyVolumes: List<Volume>? = listOf(),
    val socialVolumes: List<Volume>? = listOf(),
    val businessVolumes: List<Volume>? = listOf()
)
