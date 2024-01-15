package com.example.projecttest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

const val BASE_URL = "https://dummyjson.com/products/"

interface ApiService {

  @GET("categories")
  suspend fun getItems():List<String>


  @GET("category/{category_name}")
  suspend fun getProduct(
      @Path ("category_name") categoryName : String) : List<Product>



    companion object {

        var apiSerivce:ApiService? = null
        fun getInstance(): ApiService {

            if (apiSerivce == null){
                apiSerivce = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }

            return apiSerivce!!
        }
    }
}