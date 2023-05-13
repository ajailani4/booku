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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ajailani.booku.domain.model.Volume
import com.ajailani.booku.ui.common.UIState
import com.ajailani.booku.ui.screen.home.component.VolumeCategorySection
import com.ajailani.booku.ui.screen.home.component.SectionTitle
import com.ajailani.booku.ui.theme.Grey

@Composable
fun HomeScreen(
    fictionVolumesState: UIState<List<Volume>>,
    scienceVolumesState: UIState<List<Volume>>,
    technologyVolumesState: UIState<List<Volume>>,
    socialVolumesState: UIState<List<Volume>>,
    businessVolumesState: UIState<List<Volume>>
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
                VolumeCategorySection(
                    title = "Fiction",
                    volumesState = fictionVolumesState,
                    scaffoldState = scaffoldState
                )
                Spacer(modifier = Modifier.height(25.dp))
                VolumeCategorySection(
                    title = "Science",
                    volumesState = scienceVolumesState,
                    scaffoldState = scaffoldState
                )
                Spacer(modifier = Modifier.height(25.dp))
                VolumeCategorySection(
                    title = "Technology",
                    volumesState = technologyVolumesState,
                    scaffoldState = scaffoldState
                )
                Spacer(modifier = Modifier.height(25.dp))
                VolumeCategorySection(
                    title = "Social",
                    volumesState = socialVolumesState,
                    scaffoldState = scaffoldState
                )
                Spacer(modifier = Modifier.height(25.dp))
                VolumeCategorySection(
                    title = "Business",
                    volumesState = businessVolumesState,
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}