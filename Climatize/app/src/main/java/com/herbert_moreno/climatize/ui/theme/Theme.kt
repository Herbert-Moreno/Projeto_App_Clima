package com.herbert_moreno.climatize.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    background = PrimaryColor
)
@Composable
fun ClimatizeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}