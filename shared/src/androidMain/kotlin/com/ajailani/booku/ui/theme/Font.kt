package com.ajailani.booku.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.ajailani.booku.R

actual val manropeFamily: FontFamily = FontFamily(
    Font(
        resId = R.font.manrope_regular,
        weight = FontWeight.Normal
    ),
    Font(
        resId = R.font.manrope_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.manrope_semibold,
        weight = FontWeight.SemiBold
    ),
    Font(
        resId = R.font.manrope_bold,
        weight = FontWeight.Bold
    )
)