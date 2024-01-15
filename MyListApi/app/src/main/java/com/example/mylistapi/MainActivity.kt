package com.example.mylistapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.mylistapi.Data.Employee
import com.example.mylistapi.ViewModel.EmployeeVM
import com.example.mylistapi.ui.theme.MyListApiTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

 private val vm:EmployeeVM by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyListApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (vm.employeeName.value == null){
                            CircularProgressIndicator()
                    }else {
                        ShowList(vm)
                    }
                }
            }
        }
    }
}


@Composable
fun ShowList(employ: EmployeeVM){

    var  employee :List<Employee> = listOf()


    employ.employeeName.observe(LocalLifecycleOwner.current,{
        employee = it
    })

    if(employee.isEmpty()){

        Text(text = "NO DATA")
    } else {

        LazyColumn {

            itemsIndexed(items = employee) { index, item ->

                EmployeeItem(employee = item)
            }
        }
    }

}

@Composable
fun EmployeeItem(employee:Employee){
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(50.dp)) {

        Column {
            Text(text = employee.employee_name)
        }

    }
}



