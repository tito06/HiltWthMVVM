package com.example.applicationtest

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.applicationtest.ui.theme.ApplicationTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
   Box(modifier = Modifier.fillMaxSize(),
   contentAlignment = Alignment.Center){

       Column(modifier = Modifier
           .fillMaxSize(),
       Arrangement.Center) {

           Box(modifier = Modifier
               .fillMaxWidth()
               .height(300.dp)
               .padding(0.dp, 0.dp, 0.dp, 10.dp),
           contentAlignment = Alignment.Center){

               Column {

                   Image(painter = painterResource(id = R.drawable.logodummy),
                       contentDescription ="",
                       modifier = Modifier
                           .height(150.dp)
                           .width(200.dp))

                   Box(modifier = Modifier.height(10.dp))


                       Text(
                           text = "LOGIN HERE",
                           modifier = Modifier.padding(50.dp,0.dp,0.dp,0.dp))



               }



           }


           OutlinedTextField(modifier = Modifier
               .fillMaxWidth()
               .height(50.dp)
               .padding(20.dp, 0.dp),
               trailingIcon = {
                              Icon(Icons.Outlined.Person,
                                  contentDescription = "User")
               },
               value = "User Name", onValueChange ={} )

           Box(modifier = Modifier.height(30.dp))


       OutlinedTextField(modifier = Modifier
           .fillMaxWidth()
           .height(50.dp)
           .padding(20.dp, 0.dp),
           trailingIcon = {
                          Icon(Icons.Outlined.Lock, contentDescription = "")
           },
           value = "Password",
           onValueChange ={},
       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
       )

           Box(modifier = Modifier.height(30.dp))

           Box(modifier = Modifier.fillMaxWidth(),
           contentAlignment = Alignment.Center) {
               Button(
                   modifier = Modifier.size(150.dp, 60.dp),
                   onClick = { }) {

                   Text(text = "LOGIN",
                   style = TextStyle(
                       color = Color.White,
                       fontSize = 22.sp
                   )
                   )
               }
           }

           Box(modifier = Modifier.fillMaxSize(),
               contentAlignment = Alignment.BottomCenter){

               Text(text = "Made by Prabal Kar")
           }




       }



   }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApplicationTestTheme {
        Greeting()
    }
}