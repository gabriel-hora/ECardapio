package com.example.ecardapio.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecardapio.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val OpenSans = FontFamily(
    Font(R.font.opensans_bold, weight = FontWeight.Bold),
    Font(R.font.opensans_bolditalic, weight = FontWeight.Bold),
    Font(R.font.opensans_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.opensans_extrabolditalic, weight = FontWeight.ExtraBold),
    Font(R.font.opensans_italic, weight = FontWeight.Normal),
    Font(R.font.opensans_light, weight = FontWeight.Light),
    Font(R.font.opensans_lightitalic, weight = FontWeight.Light),
    Font(R.font.opensans_medium, weight = FontWeight.Medium),
    Font(R.font.opensans_mediumitalic, weight = FontWeight.Medium),
    Font(R.font.opensans_regular, weight = FontWeight.Normal),
    Font(R.font.opensans_semibold, weight = FontWeight.SemiBold),
    Font(R.font.opensans_semibolditalic, weight = FontWeight.SemiBold)
)