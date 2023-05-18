package com.ajailani.booku.ui.screen.home.component

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.ajailani.booku.domain.model.Volume

@Composable
expect fun VolumeCategorySection(
    scaffoldState: ScaffoldState,
    title: String,
    volumes: List<Volume>,
    onSeeMoreClicked: () -> Unit,
    onVolumeItemClicked: (String) -> Unit
)