package com.ajailani.booku.ui.screen.volume_detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ajailani.booku.ui.common.component.HtmlText
import com.ajailani.booku.ui.theme.Grey
import com.ajailani.booku.util.Constants
import com.seiko.imageloader.rememberAsyncImagePainter

@Composable
fun VolumeDetailScreen(
    volumeDetailUiState: VolumeDetailUiState,
    onNavigateUp: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onNavigateUp) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back icon"
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            volumeDetailUiState.apply {
                when {
                    loading == true -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 200.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    loading == false && errorMessage == null -> {
                        if (volumeInfo != null) {
                            Column(modifier = Modifier.padding(20.dp)) {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(width = 140.dp, height = 200.dp)
                                            .clip(MaterialTheme.shapes.large),
                                        painter = rememberAsyncImagePainter(
                                            volumeInfo.imageLinks?.thumbnail
                                                ?: Constants.URL.DEFAULT_BOOK_IMAGE
                                        ),
                                        contentScale = ContentScale.FillBounds,
                                        contentDescription = "Volume cover"
                                    )
                                    Spacer(modifier = Modifier.height(20.dp))
                                    Text(
                                        text = volumeInfo.title,
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.h2
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = volumeInfo.authors?.get(0) ?: "-",
                                        textAlign = TextAlign.Center,
                                        color = Grey
                                    )
                                }
                                Spacer(modifier = Modifier.height(25.dp))
                                Card(
                                    border = BorderStroke(
                                        width = 1.dp,
                                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
                                    ),
                                    elevation = 0.dp
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(IntrinsicSize.Min)
                                            .padding(horizontal = 20.dp, vertical = 15.dp),
                                        horizontalArrangement = Arrangement.SpaceAround
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(
                                                text = "Rating",
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.caption.copy(
                                                    color = Grey
                                                )
                                            )
                                            Spacer(modifier = Modifier.height(5.dp))
                                            Text(
                                                text = volumeInfo.averageRating.let {
                                                    if (it == null) "-" else "$it"
                                                },
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.body1.copy(
                                                    color = MaterialTheme.colors.primary,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            )
                                        }
                                        Divider(modifier = Modifier.fillMaxHeight().width(1.dp))
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(
                                                text = "Number of pages",
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.caption.copy(
                                                    color = Grey
                                                )
                                            )
                                            Spacer(modifier = Modifier.height(5.dp))
                                            Text(
                                                text = volumeInfo.pageCount.let {
                                                    if (it == null) "-" else "$it"
                                                },
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.body1.copy(
                                                    color = MaterialTheme.colors.primary,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            )
                                        }
                                        Divider(modifier = Modifier.fillMaxHeight().width(1.dp))
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(
                                                text = "Language",
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.caption.copy(
                                                    color = Grey
                                                )
                                            )
                                            Spacer(modifier = Modifier.height(5.dp))
                                            Text(
                                                text = volumeInfo.language.uppercase(),
                                                textAlign = TextAlign.Center,
                                                style = MaterialTheme.typography.body1.copy(
                                                    color = MaterialTheme.colors.primary,
                                                    fontWeight = FontWeight.SemiBold
                                                )
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(25.dp))
                                Text(
                                    text = "Description",
                                    style = MaterialTheme.typography.h3
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                HtmlText(text = volumeInfo.description ?: "-")
                            }
                        }
                    }

                    errorMessage != null -> {
                        LaunchedEffect(scaffoldState) {
                            scaffoldState.snackbarHostState.showSnackbar(errorMessage)
                        }
                    }
                }
            }
        }
    }
}