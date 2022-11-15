package com.lubnamariyam.retrofitapiinjetpackcompose.network

import com.lubnamariyam.retrofitapiinjetpackcompose.model.Group
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("grouplist.json")
    suspend fun getData() : List<Group>


    companion object {
        var apiService: ApiService? = null
        fun getInstance() : ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://exercise-646d.restdb.io/rest/group-1")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}