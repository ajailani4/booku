package com.ajailani.booku.android.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ajailani.booku.android.ui.viewmodel.HomeViewModel
import com.ajailani.booku.ui.screen.home.HomeScreen
import com.ajailani.booku.ui.screen.volume_list.VolumeListScreen
import com.ajailani.booku.util.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            val homeViewModel: HomeViewModel = koinViewModel()
            val homeUiState = homeViewModel.homeUiState

            HomeScreen(
                homeUiState = homeUiState,
                onNavigateToVolumeList = {
                    navController.navigate(Screen.VolumeList.route)
                }
            )
        }

        composable(route = Screen.VolumeList.route) {
            VolumeListScreen()
        }
    }
}