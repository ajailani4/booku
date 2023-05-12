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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun BookCategorySection() {
    val lazyListState = rememberLazyListState()

    Box {
        LazyRow(
            modifier = Modifier.padding(bottom = 20.dp),
            state = lazyListState,
            contentPadding = PaddingValues(start = 20.dp)
        ) {
            items(20) {
                BookItem()
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