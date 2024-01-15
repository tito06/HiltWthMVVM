package com.example.projecttest

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable

fun SetupNavGraph(navController:NavHostController) {

    NavHost(navController = navController,
        startDestination =Screens.mainScreen.route ){
        
        
        composable(
            route = Screens.mainScreen.route
        ){
            ItemsCategoryScreen(vm = ItemListVm())
        }

        composable(
            route = Screens.product.route,
            arguments = listOf(
                navArgument(name = "category"){
                    type = NavType.StringType
                }
            )
        ){
            val category = it.arguments?.getString("category")
            ProductScreen(category = category!!)
        }
    }

}