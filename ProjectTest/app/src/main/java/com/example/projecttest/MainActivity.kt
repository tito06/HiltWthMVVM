package com.example.projecttest

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projecttest.ui.theme.ProjectTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val itemVm = ItemListVm()
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTestTheme {
                // A surface container using the 'background' color from the theme

                Column(modifier = Modifier.fillMaxHeight()) {


                    ItemsCategoryScreen(itemVm)
                    
                    ProductOne(category = "laptops")

                }

            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsCategoryScreen(vm:ItemListVm){

    val navController = rememberNavController()
    SetupNavGraph(navController = navController)


    LaunchedEffect(Unit, block = {
        vm.getItemList()
    })

            if (vm.errorMessage == "") {
                    LazyRow(modifier = Modifier.fillMaxHeight(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                        items(vm.itemList) { item ->



                            Card(
                                modifier = Modifier
                                    .width(100.dp)
                                    .height(60.dp)
                                    .background(color = Color.Black),
                                shape = RoundedCornerShape(3.dp),
                            ) {



                                    Text(
                                        item,
                                        modifier= Modifier
                                            .padding(0.dp, 17.dp)
                                            .clickable {
                                                navController.navigate(route = "ProductScreen" + "/$item")
                                            },
                                        color = Color.Black,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )




                            }



                            Spacer(modifier = Modifier
                                .width(5.dp)
                                .background(color = Color.White))





                         }
                        }

            } else {
                Text(vm.errorMessage)
            }
        }

/*
    )
}*/

@Composable
fun ProductOne(category:String){

    val product = ProductListVm()

    LaunchedEffect(Unit, block = {
        product.getProductList(category)
    })


    if (product.errorMessage == "") {
        LazyColumn(modifier = Modifier.fillMaxHeight()){
            items(product.productList) { item ->



                Card(
                    modifier = Modifier
                        .width(100.dp)
                        .height(60.dp)
                        .background(color = Color.Black),
                    shape = RoundedCornerShape(3.dp),
                ) {



                    Text(
                        item.title,
                        modifier= Modifier
                            .padding(0.dp, 17.dp)
                            .clickable {
                            },
                        color = Color.Black,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )




                }



                Spacer(modifier = Modifier
                    .width(5.dp)
                    .background(color = Color.White))





            }
        }

    } else {
        Text(product.errorMessage)
    }
}


