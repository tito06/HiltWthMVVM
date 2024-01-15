package com.example.navigationdatabaseproject

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeRepo(private  val employeeDao: EmployeeDao) {

    val allEmployee = MutableLiveData<List<Employee>>()
    val foundEmployee = MutableLiveData<Employee>()

    private  val coroutineScope = CoroutineScope(Dispatchers.Main)


    fun getAllEmployee(){
        coroutineScope.launch(Dispatchers.IO) {
            employeeDao.getAllEmployees()
        }
    }

    fun addEmployee(newEmployee: Employee){
        coroutineScope.launch(Dispatchers.IO) {
            employeeDao.addEmployee(newEmployee)
        }
    }

    fun updateEmployeeDetails(newEmployee : Employee){
        coroutineScope.launch(Dispatchers.IO) {
            employeeDao.updateEmployeeDetails(newEmployee)
        }
    }
}