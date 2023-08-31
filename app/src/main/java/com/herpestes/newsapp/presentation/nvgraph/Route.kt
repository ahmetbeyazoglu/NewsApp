package com.herpestes.newsapp.presentation.nvgraph

sealed class Route(

    val route: String

){

    object OnBoardingScreen: Route(route = "OnBoardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")
    object DetailScreen: Route(route = "detailScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object NewsNavigation: Route(route = "newsNavigation")
    object NewsNavigatorScreen: Route(route = "newsNavigator")

}
