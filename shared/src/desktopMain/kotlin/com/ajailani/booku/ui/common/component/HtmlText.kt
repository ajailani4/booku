package com.ajailani.booku.ui.common.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.unit.dp
import java.awt.BorderLayout
import java.awt.Font
import java.awt.Insets
import javax.swing.JEditorPane
import javax.swing.JPanel

@Composable
actual fun HtmlText(text: String) {
    val textPane = JEditorPane()
    textPane.apply {
        contentType = "text/html"
        isEditable = false
        putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true)
        font = Font("Default", 0, 14)
        margin = Insets(0, 0, 0, 0)
        this.text = text
    }

    SwingPanel(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp),
        factory = {
            JPanel(BorderLayout()).apply {
                add(textPane)
            }
        }
    )
}