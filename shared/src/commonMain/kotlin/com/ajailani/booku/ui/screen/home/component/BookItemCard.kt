package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.ui.common.component.AsyncImage
import com.ajailani.booku.ui.common.component.loadImageBitmap
import com.ajailani.booku.ui.theme.Grey
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BookItem(volume: Volume) {
    Column {
        AsyncImage(
            modifier = Modifier
                .size(width = 130.dp, height = 190.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(MaterialTheme.shapes.medium),
            load = { loadImageBitmap(volume.volumeInfo.imageLinks.thumbnail) },
            painterFor = { remember { BitmapPainter(it) }},
            contentScale = ContentScale.FillBounds,
            contentDescription = "Book cover"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = volume.volumeInfo.title,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = volume.volumeInfo.authors[0],
            style = MaterialTheme.typography.body2.copy(
                color = Grey
            )
        )
    }
}