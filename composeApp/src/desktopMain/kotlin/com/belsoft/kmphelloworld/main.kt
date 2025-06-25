package com.belsoft.kmphelloworld

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMP_Hello_World",
    ) {
        App()
    }
}