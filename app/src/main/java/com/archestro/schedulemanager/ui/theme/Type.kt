package com.archestro.schedulemanager.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.archestro.schedulemanager.R

// Set of Material typography styles to start with
val playFairDisplayFont = FontFamily(
    Font(R.font.raleway_regular,FontWeight.Normal),
    Font(R.font.raleway_bold, FontWeight.Bold),
    Font(R.font.raleway_italic, style = FontStyle.Italic),
    Font(R.font.raleway_semibold, FontWeight.SemiBold)
)

/*val typography = Typography(
    defaultFontFamily = playFairDisplayFont,
)*/
// Set of Material typography styles to start with
val typography = Typography(
    body1 = TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2=TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    h1= TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    h2= TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h3= TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    h4= TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h5 = TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),
    h6 = TextStyle(
        fontFamily = playFairDisplayFont,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)