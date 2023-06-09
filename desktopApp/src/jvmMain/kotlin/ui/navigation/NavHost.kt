package ui.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.ajailani.booku.ui.screen.home.HomeScreen
import com.ajailani.booku.ui.screen.volume_detail.VolumeDetailScreen
import com.ajailani.booku.ui.screen.volume_list.VolumeListScreen
import com.ajailani.booku.util.Screen
import util.DIHelper

@Composable
fun NavHost(
    navController: NavController
) {
    Crossfade(targetState = navController.currentScreen) { screen ->
        when (screen) {
            Screen.Home.route -> {
                val homeViewModel = DIHelper().homeViewModel
                val onEvent = homeViewModel::onEvent
                val homeUiState = homeViewModel.homeUiState

                HomeScreen(
                    onEvent = onEvent,
                    homeUiState = homeUiState,
                    onNavigateToVolumeList = {
                        navController.navigate(
                            route = Screen.VolumeList.route,
                            arguments = mapOf("query" to it)
                        )
                    },
                    onNavigateToVolumeDetail = {
                        navController.navigate(
                            route = Screen.VolumeDetail.route,
                            arguments = mapOf("id" to it)
                        )
                    }
                )
            }

            Screen.VolumeList.route -> {
                val query = NavArgumentController.getArguments(Screen.VolumeList.route)?.get("query")
                val volumeListViewModel = DIHelper().volumeListViewModel
                val volumeListUiState = volumeListViewModel.volumeListUiState

                if (query != null) {
                    LaunchedEffect(query) {
                        volumeListViewModel.getVolumes(query)
                    }

                    VolumeListScreen(
                        title = query.split(":").let {
                            if (it[0] == "subject") {
                                it[1].replaceFirstChar(Char::titlecase)
                            } else {
                                query
                            }
                        },
                        volumeListUiState = volumeListUiState,
                        onNavigateUp = {
                            navController.navigateBack()
                        },
                        onNavigateToVolumeDetail = {
                            navController.navigate(
                                route = Screen.VolumeDetail.route,
                                arguments = mapOf("id" to it)
                            )
                        }
                    )
                }
            }

            Screen.VolumeDetail.route -> {
                val id = NavArgumentController.getArguments(Screen.VolumeDetail.route)?.get("id")
                val volumeDetailViewModel = DIHelper().volumeDetailViewModel
                val volumeDetailUiState = volumeDetailViewModel.volumeDetailUiState

                if (id != null) {
                    LaunchedEffect(id) {
                        volumeDetailViewModel.getVolumeDetail(id)
                    }

                    VolumeDetailScreen(
                        volumeDetailUiState = volumeDetailUiState,
                        onNavigateUp = {
                            navController.navigateBack()
                        }
                    )
                }
            }
        }
    }
}

