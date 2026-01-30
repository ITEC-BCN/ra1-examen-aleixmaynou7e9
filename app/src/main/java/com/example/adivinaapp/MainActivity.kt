package com.example.adivinaapp

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adivinaapp.view.GameScreen
import com.example.adivinaapp.view.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()
            NavHost(
                navController = navigationController,
                startDestination = Routes.Menu.route
            ) {
                composable(Routes.Menu.route) { MenuScreen(navigationController)}

                composable(Routes.Game.route,) { GameScreen(navigationController)}
            }
        }
    }}