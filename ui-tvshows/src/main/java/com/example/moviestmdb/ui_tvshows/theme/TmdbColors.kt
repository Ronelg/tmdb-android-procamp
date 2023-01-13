package com.example.moviestmdb.ui_tvshows.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// LIGHT colors
val tmdb_white_50 = Color(0xffffffff)

val tmdb_black_800 = Color(0xff121212)
val tmdb_black_900 = Color(0xff000000)

val tmdb_blue_50 = Color(0xffeef0f2)
val tmdb_blue_100 = Color(0xffd2dbe0)
val tmdb_blue_200 = Color(0xffadbbc4)
val tmdb_blue_300 = Color(0xff8ca2ae)
val tmdb_blue_600 = Color(0xff4a6572)
val tmdb_blue_700 = Color(0xff344955)
val tmdb_blue_800 = Color(0xff232f34)

val tmdb_green_300 = Color(0xff81c784)
val tmdb_green_400 = Color(0xff66bb6a)
val tmdb_green_500 = Color(0xff4caf50)

val tmdb_orange_300 = Color(0xfffbd790)
val tmdb_orange_400 = Color(0xfff9be64)
val tmdb_orange_500 = Color(0xfff9aa33)

val tmdb_red_200 = Color(0xffcf7779)
val tmdb_red_400 = Color(0xffff4c5d)
val tmdb_red_500 = Color(0xffF44336)

val tmdb_white_50_alpha_060 = Color(0x99ffffff)

val tmdb_blue_50_alpha_060 = Color(0x99eef0f2)

val tmdb_black_900_alpha_020 = Color(0x33000000)
val tmdb_black_900_alpha_087 = Color(0xde000000)
val tmdb_black_900_alpha_060 = Color(0x99000000)

val nav_bar = tmdb_black_900_alpha_020

val tmdb_popularity_bg = tmdb_black_900_alpha_087
val tmdb_popularity_high = tmdb_green_500
val tmdb_popularity_mid = tmdb_orange_500
val tmdb_popularity_low = tmdb_red_500

//DARK colors
val md_theme_dark_primary = Color(0xFFACD370)

internal val MaterialLightColors = lightColors(
    primary = tmdb_blue_700,
    primaryVariant = tmdb_blue_800,
    secondary = tmdb_blue_800,
    onPrimary = tmdb_white_50,
    background = tmdb_blue_50,
    surface = tmdb_white_50,
    error = tmdb_red_400,
    onSecondary = tmdb_black_900,
    onBackground = tmdb_black_900,
    onSurface = tmdb_black_900,
    onError = tmdb_black_900
)

internal val MaterialDarkColors = darkColors(
    primary = tmdb_blue_700,
    primaryVariant = tmdb_blue_800,
    secondary = tmdb_blue_800,
    onPrimary = tmdb_white_50,
    background = tmdb_blue_50,
    surface = tmdb_white_50,
    error = tmdb_red_400,
    onSecondary = tmdb_black_900,
    onBackground = tmdb_black_900,
    onSurface = tmdb_black_900,
    onError = tmdb_black_900
)

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
