package com.herpestes.newsapp.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.herpestes.newsapp.presentation.onboarding.Dimens.MediumPadding1
import com.herpestes.newsapp.presentation.onboarding.Dimens.MediumPadding2
import com.herpestes.newsapp.presentation.onboarding.Page
import com.herpestes.newsapp.presentation.onboarding.pages
import com.herpestes.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    Column(modifier = modifier) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = com.herpestes.newsapp.R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.h6,
            color = colorResource(id = com.herpestes.newsapp.R.color.text_medium)
        )

    }

}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES,showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    NewsAppTheme {
        OnBoardingPage(
            page = pages[0]
        )

    }
}