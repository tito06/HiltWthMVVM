package com.example.hiltmvvm

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiService {

    @GET("api/users")
    suspend fun getUsers(
        @Query ("page") page:Int
    ): Response<UserResponse>

    @GET("movielist.json")
    suspend fun getMovies() : List<Movie>


  /*  @GET("entries")
    suspend fun getEntry() : List<Entry>*/

    /*companion object{

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }



        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(25,TimeUnit.SECONDS)
        }.build()


        var apiService: ApiService?= null

        fun getInstance() : ApiService{
            if (apiService == null){
                apiService = Retrofit.Builder()
                    .baseUrl("https://reqres.in/")
                    //.baseUrl("https://api.publicapis.org/")
                    .client(client)
                    //.baseUrl("https://www.howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return  apiService!!
        }
    }*/
}