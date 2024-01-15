package com.example.projecttest

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ProductScreen(category:String){

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
