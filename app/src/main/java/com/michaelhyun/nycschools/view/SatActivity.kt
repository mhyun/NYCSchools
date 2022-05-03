package com.michaelhyun.nycschools.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.michaelhyun.nycschools.R
import com.michaelhyun.nycschools.viewmodel.NycViewModel

class SatActivity: AppCompatActivity() {

    val viewModel by viewModels<NycViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sat_activity)

        val nameTextView = findViewById<TextView>(R.id.tv_sat_school_name)
        val readingTextView = findViewById<TextView>(R.id.tv_sat_reading)
        val writingTextView = findViewById<TextView>(R.id.tv_sat_writing)
        val mathTextView = findViewById<TextView>(R.id.tv_sat_math)

        // School name is to be used in the default page in case dbn cannot be found in API
        val name = intent.getStringExtra("schoolname")
        nameTextView.text = name

        val dbn = intent.getStringExtra("dbn")
        if(dbn != null) {
            viewModel.getSatScores(dbn).observe(this, Observer {
                if (!it.isEmpty()) {
                    readingTextView.text =
                        "Critical Reading average: ${it.get(0).sat_critical_reading_avg_score.toString()}"
                    mathTextView.text =
                        "Math average: ${it.get(0).sat_math_avg_score.toString()}"
                    writingTextView.text =
                        "Writing average: ${it.get(0).sat_writing_avg_score.toString()}"
                }
            })
        }

    }
}