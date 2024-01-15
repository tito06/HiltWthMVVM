package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuteDogPicturesApp()

                }
            }
        }
    }
}

@Composable
fun CuteDogPicturesApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Feed.route) {
        composable(route = Screen.Feed.route) {
            Login(navController)
        }
        composable(route = Screen.Adopt.route) {
            HomeScreen(navController)
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Welcome to Home Screen")

        Button(onClick = {
            navController.popBackStack(Screen.Feed.route, inclusive = true)
        }) {

            Text(text = "Click to move back")
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {

    var userName by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {


        Text(text = "Login")

        TextField(value = "",
            onValueChange = { user ->
                userName = user

            })

        Box(modifier = Modifier.height(4.dp))


        Text(text = "Password")

        TextField(value = "",
            onValueChange = { pass ->
                password = pass
            })

        Box(modifier = Modifier.height(7.dp))


        Button(onClick = { navController.navigate(Screen.Adopt.route) }) {
            Text("Login")
        }
    }
}

