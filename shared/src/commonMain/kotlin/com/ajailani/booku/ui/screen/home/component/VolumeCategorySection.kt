package com.ajailani.booku.ui.screen.home.component

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.ui.common.UIState

@Composable
expect fun VolumeCategorySection(
    title: String,
    volumesState: UIState<List<Volume>>,
    scaffoldState: ScaffoldState
)