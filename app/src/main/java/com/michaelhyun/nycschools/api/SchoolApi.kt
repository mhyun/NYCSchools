package com.michaelhyun.nycschools.api

import com.michaelhyun.nycschools.model.data.Sat
import com.michaelhyun.nycschools.model.data.School
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://data.cityofnewyork.us/resource/"
const val SCHOOLS_URL = "s3k6-pzi2.json"
const val SAT_URL = "f9bf-2cp4.json?"

interface SchoolApi {

    @GET(SCHOOLS_URL)
    fun getSchoolData(): Call<List<School>>

    @GET(SAT_URL)
    fun getSatData(@Query("dbn") dbn: String): Call<List<Sat>>
}