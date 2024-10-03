package com.example.udemycompose.datasource

import com.example.udemycompose.apiclient.retrofitvar
import com.example.udemycompose.model.MarsPhoto
import retrofit2.http.GET

interface getMovies{
    @GET("photos")
    suspend fun getMovies():List<MarsPhoto>

}

object MovieApi{
    val retrofitService:getMovies by lazy {
        retrofitvar.create(getMovies::class.java)
    }
}