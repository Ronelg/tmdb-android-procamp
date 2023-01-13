package com.example.moviestmdb.ui_tvshows.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

    val extendedTypography = ExtendedTypography(
        listItem = MaterialTheme.typography.body1.copy(
            fontFamily = WorkSans,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.sp
        )
    )

    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalExtendedTypography provides extendedTypography
    ) {
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

val MaterialTheme.extendedTypography: ExtendedTypography
    @Composable
    get() = LocalExtendedTypography.current
