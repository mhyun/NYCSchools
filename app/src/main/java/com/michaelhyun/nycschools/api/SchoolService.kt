package com.michaelhyun.nycschools.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SchoolService {

    fun getService(): SchoolApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SchoolApi::class.java)
    }
}