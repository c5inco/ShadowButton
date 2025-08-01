package com.example.shadowbutton.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Ease
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Shadow as TextShadow

private val gray25 = Color(0x40050505)
private val gray100 = Color(0xFF050505)
private val gray50 = Color(0x80050505)
private val gray75 = Color(0xBF050505)
private val gray10 = Color(0x1A050505)
private val white15 = Color(0x26FFFFFF)
private val white25 = Color(0x40FFFFFF)
private val white100 = Color(0xFFFFFFFF)
private val innerButtonBackgroundColors = listOf(Color(0xffE6E6E6), Color(0xffB4B4B4))
private val innerButtonTextColors = listOf(Color(0xFF4B4B4B), Color(0xFF191919))

@Composable
fun NeumorphicButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val density = LocalDensity.current
    val pillShape = RoundedCornerShape(100)

    val innerButtonScale by
    animateFloatAsState(
        targetValue = if (isPressed) 0.975f else 1f,
        animationSpec = tween(durationMillis = 250, easing = Ease),
    )
    val innerButtonInset by
    animateDpAsState(
        targetValue = if (isPressed) 2.dp else 0.dp,
        animationSpec = tween(durationMillis = 250, easing = Ease),
    )
    val innerButtonInsetColor by
    animateColorAsState(
        targetValue = if (isPressed) gray75 else Color.Transparent,
        animationSpec = tween(durationMillis = 250, easing = Ease),
    )

    val textScale by
    animateFloatAsState(
        targetValue = if (isPressed) 0.975f else 1f,
        animationSpec = tween(durationMillis = 250, easing = Ease),
    )

    val outerShadowRadius1 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 2.4.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowSpread1 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else (-0.48).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowYOffset1 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 2.4.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val outerShadowRadius2 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 0.48.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowSpread2 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else (-0.48).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowYOffset2 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 0.48.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val outerShadowRadius3 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 4.8.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowSpread3 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else (-0.48).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowXOffset3 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 7.2.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val outerShadowYOffset3 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 14.4.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowRadius1 by
    animateDpAsState(
        targetValue = if (isPressed) 2.4.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowXOffset1 by
    animateDpAsState(
        targetValue = if (isPressed) 4.8.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowYOffset1 by
    animateDpAsState(
        targetValue = if (isPressed) 7.2.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowColor1 by
    animateColorAsState(
        targetValue = if (isPressed) gray75 else gray10,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowSpread2 by
    animateDpAsState(
        targetValue = if (isPressed) 1.2.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowXOffset2 by
    animateDpAsState(
        targetValue = if (isPressed) (-1.2).dp else (-2.4).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowYOffset2 by
    animateDpAsState(
        targetValue = if (isPressed) (-1.44).dp else (-2.4).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowColor2 by
    animateColorAsState(
        targetValue = if (isPressed) gray50 else gray25,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowRadius3 by
    animateDpAsState(
        targetValue = if (isPressed) 9.6.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowXOffset3 by
    animateDpAsState(
        targetValue = if (isPressed) 12.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowYOffset3 by
    animateDpAsState(
        targetValue = if (isPressed) 12.dp else 0.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowColor3 by
    animateColorAsState(
        targetValue = if (isPressed) gray50 else gray10,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowSpread4 by
    animateDpAsState(
        targetValue = if (isPressed) 24.dp else 9.6.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowColor4 by
    animateColorAsState(
        targetValue = if (isPressed) white15 else white25,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowRadius5 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 4.8.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowXOffset5 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 1.2.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowYOffset5 by
    animateDpAsState(
        targetValue = if (isPressed) 0.dp else 2.4.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    val innerShadowRadius7 by
    animateDpAsState(
        targetValue = if (isPressed) 9.6.dp else 12.dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )
    val innerShadowYOffset7 by
    animateDpAsState(
        targetValue = if (isPressed) (-5.76).dp else (-12).dp,
        animationSpec = tween(durationMillis = 300, easing = Ease),
    )

    Box(contentAlignment = Alignment.Center, modifier = modifier.wrapContentSize()) {
        Row(
            modifier =
                Modifier
                    .matchParentSize()
                    .offset(x = 7.2.dp, y = (-7.2).dp)
                    .dropShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = 0.6.dp,
                                brush =
                                    CssGradientBrush(
                                        angleDegrees = 135.0,
                                        colors = listOf(
                                            gray50,
                                            Color.Transparent,
                                            Color.Transparent
                                        ),
                                        stops = listOf(0f, 0.2f, 1f),
                                    ),
                                alpha = 0.25f,
                                blendMode = BlendMode.Multiply,
                            ),
                    )
        ) {}
        Row(
            modifier =
                Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = onClick,
                    )
                    .background(color = gray75, shape = pillShape)
                    .dropShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = 7.2.dp,
                                spread = (-3.6).dp,
                                offset = DpOffset((-7.2).dp, (-7.2).dp),
                                color = gray25,
                            ),
                    )
                    .dropShadow(
                        shape = pillShape,
                        shadow = Shadow(
                            radius = 3.24.dp,
                            offset = DpOffset(1.8.dp, 1.8.dp),
                            color = gray10
                        ),
                    )
                    // Outer shadows
                    .dropShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = outerShadowRadius1,
                                spread = outerShadowSpread1,
                                offset = DpOffset(0.dp, outerShadowYOffset1),
                                color = gray100,
                            ),
                    )
                    .dropShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = outerShadowRadius2,
                                spread = outerShadowSpread2,
                                offset = DpOffset(0.dp, outerShadowYOffset2),
                                color = gray50,
                            ),
                    )
                    .dropShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = outerShadowRadius3,
                                spread = outerShadowSpread3,
                                offset = DpOffset(outerShadowXOffset3, outerShadowYOffset3),
                                color = gray25,
                            ),
                    )
                    // Button background
                    .scale(innerButtonScale)
                    .border(
                        width = innerButtonInset,
                        color = innerButtonInsetColor,
                        shape = pillShape
                    )
                    .background(
                        brush = CssGradientBrush(135.0, innerButtonBackgroundColors),
                        shape = pillShape,
                    )
                    // Inner shadows
                    .innerShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = 2.4.dp,
                                spread = innerShadowSpread2,
                                offset = DpOffset(innerShadowXOffset2, innerShadowYOffset2),
                                color = innerShadowColor2,
                            ),
                    )
                    .innerShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = innerShadowRadius3,
                                spread = 0.dp,
                                offset = DpOffset(innerShadowXOffset3, innerShadowYOffset3),
                                color = innerShadowColor3,
                            ),
                    )
                    .innerShadow(
                        shape = pillShape,
                        shadow = Shadow(
                            radius = 2.4.dp,
                            spread = innerShadowSpread4,
                            color = innerShadowColor4
                        ),
                    )
                    .innerShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = innerShadowRadius5,
                                offset = DpOffset(innerShadowXOffset5, innerShadowYOffset5),
                                color = white100,
                            ),
                    )
                    .innerShadow(
                        shape = pillShape,
                        shadow = Shadow(
                            radius = 5.76.dp,
                            offset = DpOffset(5.76.dp, 5.76.dp),
                            color = white25
                        ),
                    )
                    .innerShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = innerShadowRadius7,
                                spread = 4.8.dp,
                                offset = DpOffset((-3.6).dp, innerShadowYOffset7),
                                color = gray25,
                            ),
                    ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text,
                style =
                    LocalTextStyle.current.copy(
                        brush = CssGradientBrush(135.0, innerButtonTextColors),
                        fontSize = 48.sp,
                        letterSpacing = (-2.4).sp,
                        shadow =
                            TextShadow(
                                color = Color.Black.copy(0.1f),
                                blurRadius = with(density) { 4.8.dp.toPx() },
                            ),
                    ),
                modifier = Modifier
                    .padding(horizontal = 72.dp, vertical = 48.dp)
                    .scale(textScale),
            )
        }
        Row(
            modifier =
                Modifier
                    .background(color = Color.Transparent, shape = pillShape)
                    .matchParentSize()
                    // This shadow for some reason gets covered amongst the rest of the previous hierarchy
                    // Renders better when placed on another layer, maybe a Modifier stacking bug
                    .innerShadow(
                        shape = pillShape,
                        shadow =
                            Shadow(
                                radius = innerShadowRadius1,
                                spread = 0.dp,
                                offset = DpOffset(innerShadowXOffset1, innerShadowYOffset1),
                                color = innerShadowColor1,
                            ),
                    )
        ) {}
    }
}

@Preview(showBackground = true)
@Composable
fun NeumorphicButtonPreview() {
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        NeumorphicButton(text = "Push") {
            // Handle click
        }
        NeumorphicButton(text = "Pew") {
            // Handle click
        }
    }
}
