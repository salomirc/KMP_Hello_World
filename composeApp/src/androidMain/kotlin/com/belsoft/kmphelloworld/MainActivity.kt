package com.belsoft.kmphelloworld

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices.PIXEL
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview(
    name = "Android Light Mode",
    group = "Android",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = PIXEL
)
@Preview(
    name = "Android Dark Mode",
    group = "Android",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = PIXEL
)
@Composable
fun AppAndroidPreview() {
    App()
}

@Preview(
    name = "Desktop Light Mode",
    group = "Desktop",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    device = "spec:width=1280dp,height=800dp,dpi=160"
)
@Preview(
    name = "Desktop Dark Mode",
    group = "Desktop",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    device = "spec:width=1280dp,height=800dp,dpi=160"
)
@Composable
fun AppWebPreview() {
    App(
        isDarkTheme = isSystemInDarkTheme(),
        uiContract = UIContract.Web
    )
}