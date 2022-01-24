package com.paulinasadowska.todoappcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
        surface = GrayCard,
        onSurface = OffWhite,
        primary = Blue,
        onPrimary = OffWhite,
        primaryVariant = Blue,
        secondary = RedLighter,
        background = GrayBackground,
        onBackground = OffWhite,
)

private val LightColorPalette = lightColors(
        surface = WhiteCard,
        onSurface = GrayText,
        primary = Blue,
        onPrimary = OffWhite,
        primaryVariant = Blue,
        secondary = RedDarker,
        background = WhiteBackground,
        onBackground = GrayText
)

@Composable
fun TodoAppComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}