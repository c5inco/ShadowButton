package com.example.shadowbutton.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.innerShadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow as TextShadow
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val gray25 = Color(0x40050505)
private val gray100 = Color(0xFF050505)
private val gray50 = Color(0x80050505)

private val gray10 = Color(0x1A000000)

private val innerShadowColor2 = Color(0x40FFFFFF)
private val innerShadowColor3 = Color(0xFFFFFFFF)

private val innerButtonBackgroundColors = listOf(Color(0xffE6E6E6), Color(0xffB4B4B4))
private val innerButtonTextColors = listOf(Color(0xFF4B4B4B), Color(0xFF191919))

@Composable
fun NeumorphicButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
  val density = LocalDensity.current
  val pillShape = RoundedCornerShape(100)

  Box(contentAlignment = Alignment.Center, modifier = modifier.wrapContentSize()) {
    Row(
      modifier =
        Modifier.matchParentSize()
          .offset(x = 7.2.dp, y = (-7.2).dp)
          .dropShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 0.6.dp,
                brush =
                  CssGradientBrush(
                    angleDegrees = 135.0,
                    colors = listOf(gray50, Color.Transparent, Color.Transparent),
                    stops = listOf(0f, 0.2f, 1f),
                  ),
                alpha = 0.25f,
                blendMode = BlendMode.Multiply,
              ),
          )
    ) {}
    Row(
      modifier =
        Modifier.background(color = Color.Magenta, shape = pillShape)
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
            shadow = Shadow(radius = 3.24.dp, offset = DpOffset(1.8.dp, 1.8.dp), color = gray10),
          )
          .dropShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 2.4.dp,
                spread = (-0.48).dp,
                offset = DpOffset(0.dp, 2.4.dp),
                color = gray100,
              ),
          )
          .dropShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 0.48.dp,
                spread = (-0.48).dp,
                offset = DpOffset(0.dp, 0.48.dp),
                color = gray50,
              ),
          )
          .dropShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 4.8.dp,
                spread = (-0.48).dp,
                offset = DpOffset(7.2.dp, 14.4.dp),
                color = gray25,
              ),
          )
          .background(
            brush = CssGradientBrush(135.0, innerButtonBackgroundColors),
            shape = pillShape,
          )
          .innerShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 2.4.dp,
                spread = 0.dp,
                offset = DpOffset((-2.4).dp, (-2.4).dp),
                color = gray25,
              ),
          )
          .innerShadow(
            shape = pillShape,
            shadow = Shadow(radius = 2.4.dp, spread = 9.6.dp, color = innerShadowColor2),
          )
          .innerShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 4.8.dp,
                spread = 0.dp,
                offset = DpOffset(1.2.dp, 2.4.dp),
                color = innerShadowColor3,
              ),
          )
          .innerShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 5.76.dp,
                offset = DpOffset(5.76.dp, 5.76.dp),
                color = innerShadowColor2,
              ),
          )
          .innerShadow(
            shape = pillShape,
            shadow =
              Shadow(
                radius = 12.dp,
                spread = 4.8.dp,
                offset = DpOffset((-3.6).dp, (-12).dp),
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
        modifier = Modifier.padding(horizontal = 72.dp, vertical = 48.dp),
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun NeumorphicButtonPreview() {
  Box(modifier = Modifier.padding(20.dp), contentAlignment = Alignment.Center) {
    NeumorphicButton(text = "Push") {
      // Handle click
    }
  }
}
