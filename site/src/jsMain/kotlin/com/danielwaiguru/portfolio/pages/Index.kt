package com.danielwaiguru.portfolio.pages

import androidx.compose.runtime.*
import com.danielwaiguru.portfolio.components.ProfileCard
import com.danielwaiguru.portfolio.components.ThemeSwitchButton
import com.danielwaiguru.portfolio.utils.Resources
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    var colorMode by ColorMode.currentState
    LaunchedEffect(colorMode) {
        val savedTheme = localStorage.getItem(Resources.String.SAVED_THEME) ?: ColorMode.LIGHT.name
        colorMode = ColorMode.valueOf(savedTheme)
    }

    ThemeSwitchButton(
        colorMode = colorMode,
        onClick = {
            colorMode = colorMode.opposite
            localStorage.setItem(Resources.String.SAVED_THEME, colorMode.name)
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .backgroundImage(
                linearGradient(
                    dir = LinearGradient.Direction.ToRight,
                    from = if (colorMode.isLight) Resources.Theme.GRADIENT_ONE.color
                    else Resources.Theme.GRADIENT_ONE_DARK.color,
                    to = if (colorMode.isLight) Resources.Theme.GRADIENT_TWO.color
                    else Resources.Theme.GRADIENT_TWO_DARK.color
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        ProfileCard(colorMode = colorMode)
    }
}
