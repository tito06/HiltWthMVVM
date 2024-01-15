package com.example.employeelistprac.Network

import com.example.employeelistprac.Data.Employee
import com.example.employeelistprac.Data.EmployeeList
import com.example.employeelistprac.Data.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1/employees")
    //@GET("apis/movielist.json")
    suspend fun getEmployeeList(): Response<EmployeeList>

    companion object {
        var  apiService:ApiService? = null

        fun getImstance(): ApiService{
            if (apiService == null){
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com/")
                    //.baseUrl("https://www.howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                apiService =retrofit.create(ApiService::class.java)
            }

            return apiService!!
        }
    }
}