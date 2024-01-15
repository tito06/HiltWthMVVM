package com.example.mylistapi.Repo

import com.example.mylistapi.Network.ApiService
import javax.inject.Inject

class EmployeeRepo
@Inject constructor(private  val apiService: ApiService){

    suspend fun getAllEmployee() = apiService.getEmployeeList()
}