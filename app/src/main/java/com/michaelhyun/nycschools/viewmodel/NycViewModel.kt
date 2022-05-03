package com.michaelhyun.nycschools.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michaelhyun.nycschools.api.SchoolService
import com.michaelhyun.nycschools.model.data.Sat
import com.michaelhyun.nycschools.model.data.School
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NycViewModel: ViewModel() {

    val schoolList: MutableLiveData<List<School>> by lazy {
        MutableLiveData<List<School>>().also {
            loadSchools()
        }
    }

    val satScores: MutableLiveData<List<Sat>> by lazy {
        MutableLiveData<List<Sat>>().also {
        }
    }

    fun getSatScores(dbn: String): LiveData<List<Sat>> {
        loadSat(dbn)
        return satScores
    }

    fun loadSchools() {
        val schoolData = SchoolService.getService().getSchoolData()

        schoolData.enqueue(object : Callback<List<School>?> {
            override fun onResponse(call: Call<List<School>?>, response: Response<List<School>?>) {
                schoolList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<School>?>, t: Throwable) {
                Log.d("Retrofit error: ", t.message.toString())
            }
        })
    }

    fun loadSat(dbn: String) {
        val satData = SchoolService.getService().getSatData(dbn)

        satData.enqueue(object : Callback<List<Sat>?> {
            override fun onResponse(call: Call<List<Sat>?>, response: Response<List<Sat>?>) {
                satScores.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Sat>?>, t: Throwable) {
                Log.d("Retrofit error: ", t.message.toString())
            }
        })
    }
}