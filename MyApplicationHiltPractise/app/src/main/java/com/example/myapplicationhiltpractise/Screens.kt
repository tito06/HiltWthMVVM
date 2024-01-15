package com.example.myapplicationhiltpractise

sealed class Screens(val route:String){

    object Login: Screens("login")
    object Home:Screens("home")
    object Detail: Screens("detail")
}
