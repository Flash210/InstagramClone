package com.example.instacloone.navigation

import java.lang.IllegalArgumentException

enum class AppScreens {


    HomeScreen;


    companion object{


        fun fromRoute(route:String?):AppScreens=
            when(route?.substringBefore("/")){
                HomeScreen.name->HomeScreen

                else ->
                    throw IllegalArgumentException("Route $route not found ")

            }


    }

}