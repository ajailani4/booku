package com.ajailani.booku.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ajailani.booku.android.viewmodel.HomeViewModel
import com.ajailani.booku.ui.screen.home.HomeScreen
import com.ajailani.booku.ui.theme.BookuTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BookuTheme {
                val homeViewModel: HomeViewModel = koinViewModel()
                val homeUiState = homeViewModel.homeUiState

                HomeScreen(
                    homeUiState = homeUiState
                )
            }
        }
    }
}

