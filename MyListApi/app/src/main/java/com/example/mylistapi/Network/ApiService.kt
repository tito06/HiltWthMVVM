package com.example.mylistapi.Network

import com.example.mylistapi.Data.EmployeeList
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {


    @GET("api/v1/employees")
    suspend fun getEmployeeList():Response<EmployeeList>


/*    companion object {
        var apiService:ApiService? = null
        fun getInstance() : ApiService{
            if (apiService == null){
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://dummy.restapiexample.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                apiService = retrofit.create(ApiService::class.java)

            }
            return  apiService!!
        }
    }*/

}

