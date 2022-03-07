package com.example.jetpackcamp.navigation

sealed class Screen(val route : String){
    object Welcome : Screen("welcome_screen")
    object Map : Screen("map_screen")
}
