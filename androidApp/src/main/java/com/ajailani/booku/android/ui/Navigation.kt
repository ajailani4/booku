package com.ajailani.booku.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.capitalize
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ajailani.booku.android.ui.viewmodel.HomeViewModel
import com.ajailani.booku.android.ui.viewmodel.VolumeListViewModel
import com.ajailani.booku.ui.screen.home.HomeScreen
import com.ajailani.booku.ui.screen.volume_list.VolumeListScreen
import com.ajailani.booku.util.Screen
import org.koin.androidx.compose.koinViewModel
import java.util.Locale

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            val homeViewModel = koinViewModel<HomeViewModel>()
            val onEvent = homeViewModel::onEvent
            val homeUiState = homeViewModel.homeUiState

            HomeScreen(
                onEvent = onEvent,
                homeUiState = homeUiState,
                onNavigateToVolumeList = {
                    navController.navigate(Screen.VolumeList.route + "?query=$it")
                }
            )
        }

        composable(
            route = Screen.VolumeList.route + "?query={query}",
            arguments = listOf(
                navArgument("query") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            val volumeListViewModel = koinViewModel<VolumeListViewModel>()
            var query = volumeListViewModel.query
            val volumeUiState = volumeListViewModel.volumeListUiState

            query!!.split(":").let {
                if (it[0] == "subject") {
                    query = it[1].replaceFirstChar(Char::titlecase)
                }
            }

            VolumeListScreen(
                title = query!!,
                volumeListUiState = volumeUiState,
                onNavigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}