package com.danielwaiguru.portfolio

import androidx.compose.runtime.*
import com.danielwaiguru.portfolio.utils.Resources
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.components.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.palette.button
import org.jetbrains.compose.web.css.*

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}

@InitSilk
fun overrideSilkTheme(context: InitSilkContext) {
    context.apply {
        theme.palettes.apply {
            light.apply {
                button.apply {
                    default = Resources.Theme.BLUE.color
                    hover = Resources.Theme.BLUE.color
                    pressed = Resources.Theme.BLUE.color
                }
            }

            dark.apply {
                button.apply {
                    default = Resources.Theme.LIGHT_BLUE.color
                    hover = Resources.Theme.LIGHT_BLUE.color
                    pressed = Resources.Theme.LIGHT_BLUE.color
                }
            }
        }
    }
}
