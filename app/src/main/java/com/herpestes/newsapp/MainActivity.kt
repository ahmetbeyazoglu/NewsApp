package com.herpestes.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.herpestes.newsapp.domain.usercases.AppEntryUseCases
import com.herpestes.newsapp.domain.usercases.SaveAppEntry
import com.herpestes.newsapp.presentation.nvgraph.NavGraph
import com.herpestes.newsapp.presentation.onboarding.OnBoardingScreen
import com.herpestes.newsapp.presentation.onboarding.OnBoardingViewModel
import com.herpestes.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.splashCondition
            }

        }


        setContent {
            NewsAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colors.background)){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)

                }


            }
        }
    }


}



