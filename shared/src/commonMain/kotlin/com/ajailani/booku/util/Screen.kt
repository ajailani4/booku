package com.ajailani.booku.util

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object VolumeList : Screen("volume_list_screen")
    object VolumeDetail : Screen("volume_detail_screen")
}