package com.example.myapplication

sealed class Screen(val route: String){

    object Feed: Screen("feed")
    object Adopt: Screen("adopt")
}