package com.example.projecttest

import java.util.Objects

sealed class Screens(val route: String){

    object mainScreen : Screens(route = "itemCategoryScreen")
    object product : Screens(route = "ProductScreen" + "/{category}")
}
