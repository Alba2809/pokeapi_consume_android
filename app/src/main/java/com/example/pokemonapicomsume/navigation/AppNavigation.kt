package com.example.pokemonapicomsume.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemonapicomsume.ui.view.DetailsScreen
import com.example.pokemonapicomsume.ui.view.HomeScreen
import com.example.pokemonapicomsume.ui.view.SplashScreen
import com.example.pokemonapicomsume.ui.viewmodel.HomeViewModel

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(durationMillis = 1000)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -1000 },
                animationSpec = tween(durationMillis = 1000)
            )
        }
    ){
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController, HomeViewModel())
        }

        composable(route = AppScreens.DetailsScreen.route){
            DetailsScreen(navController)
        }
    }
}