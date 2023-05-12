package com.ajailani.booku.ui.screen.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ajailani.booku.ui.theme.Grey
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BookItem() {
    Column {
        Image(
            modifier = Modifier
                .size(width = 130.dp, height = 190.dp)
                .shadow(
                    elevation = 2.dp,
                    shape = MaterialTheme.shapes.medium
                )
                .clip(MaterialTheme.shapes.medium),
            painter = painterResource("image/sapiens_cover.jpg"),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Book cover"
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sapiens",
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Yuval Noah Harari",
            style = MaterialTheme.typography.body2.copy(
                color = Grey
            )
        )
    }
}