package com.example.employeelistprac

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.employeelistprac.Data.Employee

@Composable
fun EmplyList(empList: List<Employee>){

    LazyColumn{
        itemsIndexed(items = empList){index, item ->
            EmployeeItem(employeeData = item)
        }
    }
}


@Composable
fun EmployeeItem(employeeData: Employee){

    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .height(50.dp)) {

        Text(text = employeeData.employee_name)
    }
}