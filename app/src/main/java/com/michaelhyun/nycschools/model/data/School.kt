package com.michaelhyun.nycschools.model.data

import com.google.gson.annotations.SerializedName

data class School(
    @SerializedName("school_name")
    val school_name: String,
    @SerializedName("school_email")
    val school_email: String,
    @SerializedName("dbn")
    val dbn: String
)