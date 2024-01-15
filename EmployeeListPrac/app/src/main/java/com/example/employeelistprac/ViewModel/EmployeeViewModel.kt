package com.example.employeelistprac.ViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeelistprac.Data.Employee
import com.example.employeelistprac.Data.Movie
import com.example.employeelistprac.Network.ApiService
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {

    var employeeName:List<Employee> by mutableStateOf(listOf())
    //private val employeeName = mutableStateListOf<EmployeeData>()
    var errorMessage: String by mutableStateOf("")

  /*  val empNameList : List<Movie>
        get() = employeeName*/

    fun getEmployeeList(){
        viewModelScope.launch {
            val apiService = ApiService.getImstance()
            try {
                val empList = apiService.getEmployeeList()
                employeeName = empList.body()!!.data



                Log.v("EMPLOYEE", employeeName.toString())
            }catch (e:Exception){

                Log.v("EXCEPTIOON", e.message.toString())
            }
        }
    }
}