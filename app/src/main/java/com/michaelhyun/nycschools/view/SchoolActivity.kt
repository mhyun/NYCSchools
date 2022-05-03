package com.michaelhyun.nycschools.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.michaelhyun.nycschools.R
import com.michaelhyun.nycschools.viewmodel.NycViewModel
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

class SchoolActivity : AppCompatActivity() {

    private val viewModel by viewModels<NycViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.school_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_schools)

        viewModel.schoolList.observe(this, Observer { it
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@SchoolActivity)
                adapter = RecyclerAdapter(this@SchoolActivity, it)
            }
        })
    }
}