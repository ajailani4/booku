package com.ajailani.booku.ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.ui.theme.Grey
import com.ajailani.booku.util.Constants
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun VolumeItem(
    volume: Volume,
    width: Dp = 140.dp,
    height: Dp = 250.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(horizontal = 10.dp)) {
            CompositionLocalProvider {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2.5f)
                        .shadow(
                            elevation = 2.dp,
                            shape = MaterialTheme.shapes.medium
                        )
                        .clip(MaterialTheme.shapes.medium),
                    painter = rememberAsyncImagePainter(
                        volume.volumeInfo.imageLinks?.thumbnail ?: Constants.URL.DEFAULT_BOOK_IMAGE
                    ),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "Book cover"
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = volume.volumeInfo.title,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = volume.volumeInfo.authors?.get(0) ?: "-",
                    style = MaterialTheme.typography.body2.copy(
                        color = Grey
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}