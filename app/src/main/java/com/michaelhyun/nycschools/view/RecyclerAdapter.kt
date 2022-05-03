package com.michaelhyun.nycschools.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.michaelhyun.nycschools.R
import com.michaelhyun.nycschools.model.data.School

class RecyclerAdapter(val context: Context, val schools: List<School>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val schoolName = view?.findViewById<TextView>(R.id.tv_school_name)
        val email = view?.findViewById<TextView>(R.id.tv_school_email)
        val dbn = view?.findViewById<TextView>(R.id.tv_school_dbn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.school_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.schoolName.text = schools[position].school_name
        holder.email.text = schools[position].school_email
        holder.dbn.text = schools[position].dbn

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, SatActivity::class.java)
            intent.putExtra("dbn", schools[position].dbn)
            intent.putExtra("schoolname", schools[position].school_name)

            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        return schools.count()
    }
}