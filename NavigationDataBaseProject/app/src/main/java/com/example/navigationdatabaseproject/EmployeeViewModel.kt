package com.example.navigationdatabaseproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val employeeRepo: EmployeeRepo)
    :ViewModel() {

    val employeeList: LiveData<List<Employee>> = employeeRepo.allEmployee

    val foundEmployee: LiveData<Employee> =employeeRepo.foundEmployee


    fun getAllEmployee(){
        employeeRepo.getAllEmployee()
    }


    fun addEmployee(employee: Employee){
        employeeRepo.addEmployee(employee)
        getAllEmployee()
    }

    fun updateEmployeeDetails(employee: Employee){
        employeeRepo.updateEmployeeDetails(employee)
        getAllEmployee()
    }
}