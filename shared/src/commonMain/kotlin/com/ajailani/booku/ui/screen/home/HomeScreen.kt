package com.ajailani.booku.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.booku.ui.screen.home.component.VolumeCategorySection
import com.ajailani.booku.ui.theme.Grey

@Composable
fun HomeScreen(
    homeUiState: HomeUiState
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Hello",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Find the best books here",
                            color = Grey
                        )
                    }
                    IconButton(
                        modifier = Modifier.size(24.dp),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search book icon"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                homeUiState.apply {
                    when {
                        loading == true -> {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 180.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }

                        loading == false && errorMessage == null -> {
                            homeUiState.apply {
                                VolumeCategorySection(
                                    title = "Fiction",
                                    volumes = fictionVolumes,
                                    scaffoldState = scaffoldState
                                )
                                Spacer(modifier = Modifier.height(25.dp))
                                VolumeCategorySection(
                                    title = "Science",
                                    volumes = scienceVolumes,
                                    scaffoldState = scaffoldState
                                )
                                Spacer(modifier = Modifier.height(25.dp))
                                VolumeCategorySection(
                                    title = "Technology",
                                    volumes = technologyVolumes,
                                    scaffoldState = scaffoldState
                                )
                                Spacer(modifier = Modifier.height(25.dp))
                                VolumeCategorySection(
                                    title = "Social",
                                    volumes = socialVolumes,
                                    scaffoldState = scaffoldState
                                )
                                Spacer(modifier = Modifier.height(25.dp))
                                VolumeCategorySection(
                                    title = "Business",
                                    volumes = businessVolumes,
                                    scaffoldState = scaffoldState
                                )
                                Spacer(modifier = Modifier.height(25.dp))
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
}