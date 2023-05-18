package com.ajailani.booku.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.ajailani.booku.ui.screen.home.component.VolumeCategorySection
import com.ajailani.booku.ui.theme.Grey
import com.ajailani.booku.ui.theme.SearchTextFieldGrey

@Composable
fun HomeScreen(
    onEvent: (HomeEvent) -> Unit,
    homeUiState: HomeUiState,
    onNavigateToVolumeList: (String) -> Unit
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
                // Header
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Hello",
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Find the best books here",
                        color = Grey
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    SearchTextField(
                        searchQuery = homeUiState.searchQuery,
                        onSearchQueryChanged = {
                            onEvent(HomeEvent.OnSearchQueryChanged(it))
                        },
                        onSearched = {
                            onNavigateToVolumeList(homeUiState.searchQuery)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

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
                            VolumeCategorySection(
                                scaffoldState = scaffoldState,
                                title = "Fiction",
                                volumes = fictionVolumes,
                                onSeeMoreClicked = {
                                    onNavigateToVolumeList("subject:fiction")
                                },
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            VolumeCategorySection(
                                scaffoldState = scaffoldState,
                                title = "Science",
                                volumes = scienceVolumes,
                                onSeeMoreClicked = {
                                    onNavigateToVolumeList("subject:science")
                                },
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            VolumeCategorySection(
                                scaffoldState = scaffoldState,
                                title = "Technology",
                                volumes = technologyVolumes,
                                onSeeMoreClicked = {
                                    onNavigateToVolumeList("subject:technology")
                                },
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            VolumeCategorySection(
                                scaffoldState = scaffoldState,
                                title = "Social",
                                volumes = socialVolumes,
                                onSeeMoreClicked = {
                                    onNavigateToVolumeList("subject:social")
                                },
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            VolumeCategorySection(
                                scaffoldState = scaffoldState,
                                title = "Business",
                                volumes = businessVolumes,
                                onSeeMoreClicked = {
                                    onNavigateToVolumeList("subject:business")
                                },
                            )
                            Spacer(modifier = Modifier.height(25.dp))
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun SearchTextField(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    onSearched: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    var isFocused by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.SearchTextFieldGrey,
                shape = CircleShape
            )
            .fillMaxWidth()
            .onFocusChanged { isFocused = it.isFocused }
            .onKeyEvent {
                if (it.key == Key.Enter) {
                    onSearched()
                    true
                } else {
                    false
                }
            },
        value = searchQuery,
        onValueChange = onSearchQueryChanged,
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colors.primary),
        textStyle = MaterialTheme.typography.body1.copy(
            color = MaterialTheme.colors.onBackground
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            focusManager.clearFocus()
            keyboardController?.hide()

            onSearched()
        }),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Grey,
                    contentDescription = "Search icon"
                )
                Spacer(modifier = Modifier.width(12.dp))

                if (searchQuery.isEmpty() && !isFocused) {
                    Text(
                        text = "Search Books",
                        color = Grey
                    )
                }

                innerTextField()
            }
        }
    )
}