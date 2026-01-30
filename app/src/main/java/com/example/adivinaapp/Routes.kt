package com.example.adivinaapp

sealed class Routes(val route: String)
{
    object Game :Routes( "game/{secretNumber}")
    object Menu :Routes( "menu")

    fun createRoute (secretNumber: Int) =
        "game/$secretNumber "

}
