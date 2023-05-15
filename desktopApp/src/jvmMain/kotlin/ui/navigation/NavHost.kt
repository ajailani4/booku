package ui.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import com.ajailani.booku.ui.screen.home.HomeScreen
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
                val homeUiState = homeViewModel.homeUiState

                HomeScreen(
                    homeUiState = homeUiState,
                    onNavigateToVolumeList = {
                        navController.navigate(Screen.VolumeList.route)
                    }
                )
            }

            Screen.VolumeList.route -> {
                VolumeListScreen(
                    onNavigateUp = {
                        navController.navigateBack()
                    }
                )
            }
        }
    }
}

