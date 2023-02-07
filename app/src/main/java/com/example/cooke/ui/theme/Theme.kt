package com.example.cooke.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



private val DarkColorPalette = darkColors(
    primary = Color(0xff01333d),
    onPrimary = Color(0xff001f25),
    primaryVariant = Color(0xff359cb5),
    background = Color(0xff015a6b),
    secondary = Color(0xfff8fdff),

)

private val LightColorPalette = lightColors(
    primary = Color(0xffF06292), //top bar
    onPrimary = Color(0xffBA2D65), //system bar
    primaryVariant = Color(0xffffd9e1), //recipe card color
    background = Color(0xffffffff),
    secondary = Color(0xff3f001b) //text
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun CookETheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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
