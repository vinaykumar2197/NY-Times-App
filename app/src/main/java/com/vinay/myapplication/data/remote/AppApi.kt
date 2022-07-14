package com.vinay.myapplication.data.remote

import com.example.example.NyModel
import com.vinay.myapplication.BuildConfig
import retrofit2.http.GET

interface AppApi {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=${BuildConfig.API_KEY}")
    suspend fun getListings(): NyModel

    companion object {
        const val BASE_URL = BuildConfig.BASE_URL
    }
}