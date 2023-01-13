package com.example.moviestmdb.ui_tvshows.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalTextApi::class)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = com.example.moviestmdb.core_ui.R.array.com_google_android_gms_fonts_certs
)

@OptIn(ExperimentalTextApi::class)
val WorkSans = FontFamily(
    Font(googleFont = GoogleFont("Work Sans"), fontProvider = provider),
    Font(googleFont = GoogleFont("Work Sans&amp;weight=700"), fontProvider = provider, weight = FontWeight.W700),
    Font(googleFont = GoogleFont("Work Sans&amp;weight=800"), fontProvider = provider, weight = FontWeight.W800),
    Font(googleFont = GoogleFont("Work Sans&amp;weight=500"), fontProvider = provider, weight = FontWeight.W500),
    Font(googleFont = GoogleFont("Work Sans&amp;weight=600"), fontProvider = provider, weight = FontWeight.W600)
)

val MaterialTypography = Typography(
    h2 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.W600,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.W500,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    body1 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 14.sp,
        letterSpacing = 0.5.sp
    ),
    body2 = TextStyle(
        fontFamily = WorkSans,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = WorkSans,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    )
)

@Immutable
data class ExtendedTypography(
    val listItem: TextStyle
)

val LocalExtendedTypography = staticCompositionLocalOf {
    ExtendedTypography(listItem = TextStyle.Default)
}
