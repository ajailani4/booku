package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.HorizontalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@Composable
actual fun VolumeCategorySection(
    title: String,
    volumes: List<Volume>?,
    scaffoldState: ScaffoldState
) {
    val lazyListState = rememberLazyListState()

    SectionTitle(
        title = title,
        onSeeMoreClicked = {}
    )
    Spacer(modifier = Modifier.height(15.dp))

    volumes?.let {
        Box {
            LazyRow(
                modifier = Modifier.padding(bottom = 20.dp),
                state = lazyListState,
                contentPadding = PaddingValues(horizontal = 20.dp)
            ) {
                items(it) { volume ->
                    BookItem(
                        volume = volume,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.width(15.dp))
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
}