package com.herpestes.newsapp.presentation.nvgraph

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.herpestes.newsapp.presentation.home.HomeScreen
import com.herpestes.newsapp.presentation.home.HomeViewModel
import com.herpestes.newsapp.presentation.onboarding.OnBoardingScreen
import com.herpestes.newsapp.presentation.onboarding.OnBoardingViewModel
import com.herpestes.newsapp.presentation.search.SearchScreen
import com.herpestes.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }

        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(route= Route.NewsNavigatorScreen.route){
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state =viewModel.state.value , event = viewModel::onEvent, navigate = {})
            }
        }
    }
}