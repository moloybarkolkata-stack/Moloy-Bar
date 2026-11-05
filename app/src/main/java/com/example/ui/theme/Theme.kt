package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = AquaMintPrimary,
    onPrimary = AquaMintOnPrimary,
    primaryContainer = AquaMintContainer,
    onPrimaryContainer = AquaMintOnContainer,
    secondary = EmeraldSecondary,
    onSecondary = EmeraldOnSecondary,
    secondaryContainer = EmeraldSecondaryContainer,
    onSecondaryContainer = EmeraldOnSecondaryContainer,
    tertiary = AnthocyaninCoralTertiary,
    onTertiary = AnthocyaninOnTertiary,
    tertiaryContainer = AnthocyaninTertiaryContainer,
    onTertiaryContainer = AnthocyaninOnTertiaryContainer,
    background = AbyssBackground,
    onBackground = AbyssOnBackground,
    surface = AbyssSurface,
    onSurface = AbyssOnSurface,
    surfaceVariant = AbyssSurfaceVariant,
    onSurfaceVariant = AbyssOnSurfaceVariant,
    outline = AbyssSurfaceOutline
)

private val LightColorScheme = lightColorScheme(
    primary = AquaMintContainer,
    onPrimary = FreshSurfaceLight,
    primaryContainer = AquaMintOnContainer,
    onPrimaryContainer = AquaMintOnPrimary,
    secondary = EmeraldSecondaryContainer,
    onSecondary = FreshSurfaceLight,
    secondaryContainer = EmeraldOnSecondaryContainer,
    onSecondaryContainer = EmeraldOnSecondary,
    tertiary = AnthocyaninTertiaryContainer,
    onTertiary = FreshSurfaceLight,
    tertiaryContainer = AnthocyaninOnTertiaryContainer,
    onTertiaryContainer = AnthocyaninOnTertiary,
    background = FreshBackgroundLight,
    onBackground = FreshOnBackgroundLight,
    surface = FreshSurfaceLight,
    onSurface = FreshOnSurfaceLight,
    surfaceVariant = FreshSurfaceVariantLight,
    onSurfaceVariant = FreshOnSurfaceVariantLight,
    outline = FreshSurfaceOutlineLight
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = true, // Default to rich dark aquatic theme for vibrant contrast
    dynamicColor: Boolean = false, // Preserve crafted aquatic identity
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
