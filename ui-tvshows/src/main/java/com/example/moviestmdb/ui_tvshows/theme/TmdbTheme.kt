@file:OptIn(ExperimentalTextApi::class)

package com.example.moviestmdb.ui_tvshows.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi


@Immutable
data class ExtendedColors(
    val tertiary: Color,
    val onTertiary: Color
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        tertiary = Color.Unspecified,
        onTertiary = Color.Unspecified
    )
}

@Composable
fun TmdbTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val materialColors = if (!useDarkTheme) {
        MaterialLightColors
    } else {
        MaterialDarkColors
    }
    val extendedColors = ExtendedColors(
        tertiary = Color(0xFFA8EFF0),
        onTertiary = Color(0xFF002021)
    )
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colors = materialColors,
            typography = MaterialTypography,
        ) {
            content()
        }
    }
}

val MaterialTheme.extendedColors: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
