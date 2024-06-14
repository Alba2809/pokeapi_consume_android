package com.example.pokemonapicomsume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.pokemonapicomsume.navigation.AppNavigation
import com.example.pokemonapicomsume.ui.theme.PokemonApiComsumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonApiComsumeTheme {
                AppNavigation()
            }
        }
    }
}
