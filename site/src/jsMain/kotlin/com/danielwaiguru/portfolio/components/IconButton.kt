package com.danielwaiguru.portfolio.components

import androidx.compose.runtime.Composable
import com.danielwaiguru.portfolio.utils.Resources
import com.danielwaiguru.portfolio.utils.Resources.Dimens.BORDER_RADIUS
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px

@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    colorMode: ColorMode,
    link: String = "",
    icon: String,
    iconSize: CSSSizeValue<CSSUnit.px> = Resources.Dimens.ICON_SIZE.px,
    onClick: (() -> Unit)? = null
) {
    Link(path = link) {
        Box(
            modifier = modifier
                .padding(all = 8.px)
                .borderRadius(r = BORDER_RADIUS.px)
                .cursor(Cursor.Pointer)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = if (colorMode.isLight) Resources.Theme.SOCIAL_ICON_BACKGROUND_LIGHT.color
                    else Resources.Theme.SOCIAL_ICON_BACKGROUND_DARK.color
                )
                .onClick { onClick?.invoke() }
        ){
            Image(
                modifier = Modifier.size(iconSize),
                src = icon
            )
        }
    }
}

enum class SocialIcon(
    val icon: String,
    val link: String
) {
    Github(
        icon = Resources.Icon.GITHUB,
        link = "https://github.com/daniel-waiguru"
    ),
    GithubLight(
        icon = Resources.Icon.GITHUB_LIGHT,
        link = "https://github.com/daniel-waiguru"
    )
//    ,
//    Gitlab(
//        icon = Resources.Icon.GITLAB,
//        link = "https://gitlab.com"
//    ),
//    GitlabLight(
//        icon = Resources.Icon.GITLAB_LIGHT,
//        link = "https://gitlab.com"
//    )
    ,
    Instagram(
        icon = Resources.Icon.INSTAGRAM,
        link = "https://www.instagram.com/_danielwaiguru/"
    ),
    InstagramLight(
        icon = Resources.Icon.INSTAGRAM_LIGHT,
        link = "https://www.instagram.com/_danielwaiguru/"
    )
}