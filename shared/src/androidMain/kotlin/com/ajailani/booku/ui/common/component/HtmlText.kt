package com.ajailani.booku.ui.common.component

import android.graphics.Color
import android.graphics.Typeface
import android.text.Html
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.res.ResourcesCompat
import androidx.core.text.HtmlCompat
import com.ajailani.booku.R

@Composable
actual fun HtmlText(text: String) {
    AndroidView(
        factory = { context ->
            val typeface = ResourcesCompat.getFont(context, R.font.manrope_regular)

            TextView(context).apply {
                this.text = Html.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
                setTextColor(Color.BLACK)
                setTypeface(typeface)
            }
        }
    )
}