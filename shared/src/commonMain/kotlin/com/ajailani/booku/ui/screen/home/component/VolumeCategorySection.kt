package com.ajailani.booku.ui.screen.home.component

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.ajailani.booku.domain.model.Volume

@Composable
expect fun VolumeCategorySection(
    title: String,
    volumes: List<Volume>?,
    onNavigateToVolumeList: () -> Unit,
    scaffoldState: ScaffoldState
)