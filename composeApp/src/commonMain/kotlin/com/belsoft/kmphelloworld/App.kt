package com.belsoft.kmphelloworld

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import kmp_hello_world.composeapp.generated.resources.Res
import kmp_hello_world.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    isDarkTheme: Boolean = false,
    uiContract: UIContract = getPlatform().uiContract
) {
    var isDarkTheme by remember { mutableStateOf(isDarkTheme) }

    MyApplicationTheme(
        isDarkTheme = if (uiContract.isSystemTheme) isSystemInDarkTheme() else isDarkTheme
    ) {
        var showContent by remember { mutableStateOf(false) }

        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (uiContract.isThemeToggleVisible) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Light/Dark Theme",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .width(32.dp)
                                .height(24.dp)
                                .clipToBounds(),
                            contentAlignment = Alignment.Center
                        ) {
                            Switch(
                                checked = isDarkTheme,
                                onCheckedChange = { isChecked ->
                                    isDarkTheme = isChecked
                                },
                                modifier = Modifier.scale(0.5f)

                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = { showContent = !showContent }) {
                        Text("Click me!")
                    }
                    AnimatedVisibility(showContent) {
                        val greeting = remember { Greeting().greet() }
                        Column(
                            Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(Res.drawable.compose_multiplatform),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp)
                            )
                            Text("Compose: $greeting")
                        }
                    }
                }
            }
        }
    }
}