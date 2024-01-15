package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.theme.TestAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   // ProfileScreen()

                    CityList()

                }
            }
        }
    }
}


@Composable
fun ProfileScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.teal_700))) {

            Row(modifier = Modifier.width(270.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top) {

             Icon(
                 modifier = Modifier.size(50.dp),
                 imageVector = Icons.Default.ArrowBack,
                 contentDescription = "Back Button",
             tint = Color.White)
                
                Box(modifier = Modifier.width(50.dp))


             Column(verticalArrangement = Arrangement.Center) {

                 Icon(
                     modifier = Modifier
                         .size(70.dp)
                         .padding(10.dp, 0.dp),
                     imageVector = Icons.Default.Person ,
                     contentDescription ="Person Profile")

                 Text(modifier = Modifier.padding(10.dp,0.dp),

                     text = "NAME",
                 fontSize = 20.sp,
                 color = Color.White)

                 
                 Box(modifier = Modifier.height(10.dp))

                 Box(modifier = Modifier
                     .height(30.dp)
                     .width(120.dp)
                     .clip(CircleShape)
                     .background(color = Color.White)) {

                     Row {
                         Text(text = "Connected",
                         modifier = Modifier.padding(10.dp,5.dp))

                     }
                 }

                 //CityList()

             }

            }


        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun CityList() {

    val items = listOf<String>("app", "movie")
    var pagerState = rememberPagerState(0)
    val coroutineScope = rememberCoroutineScope()

    Column {


        TabRow(selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color.White,
            modifier = Modifier
                .padding(20.dp)
                .background(color = Color.Transparent)
                .clip(RoundedCornerShape(30.dp)),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .width(0.dp)
                        .height(0.dp)
                )
            }

        ) {


            items.forEachIndexed { index, title ->

                Tab(
                    text = {
                        Text(text = title.toString())
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier.background(
                        shape = RoundedCornerShape(30.dp),
                        color = Color.Blue
                    ),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )


            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) { page ->

            Text(
                text = items[page],
                modifier = Modifier.padding(50.dp),
                color = Color.White
            )
        }
    }
}


