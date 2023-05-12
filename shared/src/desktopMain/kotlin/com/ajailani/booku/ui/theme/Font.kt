package com.ajailani.booku.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

actual val manropeFamily = FontFamily(
    Font(
        resource = "font/manrope_regular.ttf",
        weight = FontWeight.Normal
    ),
    Font(
        resource = "font/manrope_medium.ttf",
        weight = FontWeight.Medium
    ),
    Font(
        resource = "font/manrope_semibold.ttf",
        weight = FontWeight.SemiBold
    ),
    Font(
        resource = "font/manrope_bold.ttf",
        weight = FontWeight.Bold
    )
)