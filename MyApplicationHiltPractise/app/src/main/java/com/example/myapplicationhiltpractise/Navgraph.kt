package com.example.myapplicationhiltpractise

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController){

   NavHost(navController = navController,
       startDestination = Screens.Login.route){

       composable(route = Screens.Login.route){
           Login(navController)
       }

       composable(route = Screens.Home.route){
           Home(navController)
       }

       composable(route = Screens.Detail.route + "/{name}"){

           val name = it.arguments?.getString("name")

           Detail(name = name.toString())
       }
   }

}