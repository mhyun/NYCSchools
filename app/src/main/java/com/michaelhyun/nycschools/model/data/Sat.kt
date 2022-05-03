package com.michaelhyun.nycschools.model.data

import com.google.gson.annotations.SerializedName

data class Sat(
    @SerializedName("sat_critical_reading_avg_score")
    val sat_critical_reading_avg_score: String,
    @SerializedName("sat_math_avg_score")
    val sat_math_avg_score: String,
    @SerializedName("sat_writing_avg_score")
    val sat_writing_avg_score: String,
    @SerializedName("school_name")
    val school_name: String
)