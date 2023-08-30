package com.herpestes.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import com.herpestes.newsapp.presentation.onboarding.Dimens.IndicatorSize

@Composable
fun PageIndicator(

    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colors.primary,
    unselectedColor: Color = Blue

    ){

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize){ page ->
            Box(modifier = Modifier.size(IndicatorSize).clip(CircleShape)
                .background(color = if (page == selectedPage) selectedColor else unselectedColor)



            )
        }
    }

}