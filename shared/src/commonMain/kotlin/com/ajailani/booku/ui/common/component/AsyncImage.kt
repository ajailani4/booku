package com.ajailani.booku.ui.common.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.loadImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.URL

@Composable
fun <T> AsyncImage(
    modifier: Modifier = Modifier,
    load: suspend () -> T,
    painterFor: @Composable (T) -> Painter,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String
) {
    val image: T? by produceState<T?>(null) {
        value = withContext(Dispatchers.IO) {
            try {
                load()
            } catch (e: IOException) {
                println(e.message)
                null
            }
        }
    }

    if (image != null) {
        Image(
            modifier = modifier,
            painter = painterFor(image!!),
            contentScale = contentScale,
            contentDescription = contentDescription
        )
    }
}

fun loadImageBitmap(url: String): ImageBitmap =
    URL(url).openStream().buffered().use(::loadImageBitmap)