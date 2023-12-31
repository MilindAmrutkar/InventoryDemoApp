package com.backtocoding.inventorydemoapp.data.api

import com.backtocoding.inventorydemoapp.data.model.ItemResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("kappa/image/task")
    suspend fun fetchItems(): ItemResponse

    companion object {
        private const val BASE_URL = "https://db.ezobooks.in/"

        fun create(): ApiService {
            val moshi = Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(ApiService::class.java)
        }
    }
}