package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.ui.common.component.VolumeItem

@Composable
actual fun VolumeCategorySection(
    scaffoldState: ScaffoldState,
    title: String,
    volumes: List<Volume>,
    onSeeMoreClicked: () -> Unit,
    onVolumeItemClicked: (String) -> Unit
) {
    val lazyListState = rememberLazyListState()

    SectionTitle(
        title = title,
        onSeeMoreClicked = onSeeMoreClicked
    )
    Spacer(modifier = Modifier.height(15.dp))

    Box {
        LazyRow(
            modifier = Modifier.padding(bottom = 20.dp),
            state = lazyListState,
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items(volumes) {
                VolumeItem(
                    volume = it,
                    onClick = { onVolumeItemClicked(it.id) }
                )
            }
        }
        HorizontalScrollbar(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth(),
            adapter = rememberScrollbarAdapter(scrollState = lazyListState)
        )
    }
}