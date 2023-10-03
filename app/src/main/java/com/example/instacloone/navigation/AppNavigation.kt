package com.example.instacloone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instacloone.screens.HomeScreen


@Composable
fun AppNavigation(){

    val navController= rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name){


        composable(AppScreens.HomeScreen.name){
            HomeScreen()
        }
    }






}