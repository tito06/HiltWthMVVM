package com.example.myapplicationhiltpractise

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController){
    
    var name by remember { mutableStateOf(TextFieldValue("")) }


Column(modifier = Modifier
    .fillMaxSize()
    .background(color = Color.White)) {


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
    horizontalArrangement = Arrangement.Center) {

        Text(text = "Home Screen",
        fontWeight = FontWeight.Bold)

    }


    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.Center) {


        OutlinedTextField(value = name,
            label = { Text(text = "Enter your Name")},
            onValueChange = {
                name = it
            })

    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.Center) {


       Button(onClick = {
                        navController.navigate(Screens.Detail.route + "/${name.text}")
       },
           shape = MaterialTheme.shapes.medium,
           colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
           modifier = Modifier.padding(5.dp),
       ) {
           Text(
               text = "Go to Home Screen",
               modifier = Modifier.padding(5.dp),
               color = Color.White
           )
       }

    }



}

}