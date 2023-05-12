package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
actual fun BookCategorySection() {
    LazyRow(contentPadding = PaddingValues(start = 20.dp)) {
        items(20) {
            BookItem()
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}