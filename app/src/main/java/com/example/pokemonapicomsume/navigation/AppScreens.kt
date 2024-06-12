package com.example.pokemonapicomsume.navigation

sealed class AppScreens(val route: String){
    data object SplashScreen: AppScreens("splash_screen")
    data object HomeScreen: AppScreens("home_screen")
    data object DetailsScreen: AppScreens("details_screen")
}