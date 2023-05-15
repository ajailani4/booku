package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.booku.domain.model.Volume

@Composable
actual fun VolumeCategorySection(
    title: String,
    volumes: List<Volume>?,
    scaffoldState: ScaffoldState
) {
    SectionTitle(
        title = title,
        onSeeMoreClicked = {}
    )
    Spacer(modifier = Modifier.height(15.dp))
    volumes?.let {
        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp)) {
            items(it) { volume ->
                BookItem(
                    volume = volume,
                    onClick = {}
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}