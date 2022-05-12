package com.example.bscsitsampleproject1.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.bscsitsampleproject1.R
import com.example.bscsitsampleproject1.model.StudentModel

class RecyclerViewAdapter(
    private val context: Context,
    private var dataList: ArrayList<StudentModel>,
    private var cellClick: StudentClickListener,
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.student_list,
                null
            )
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataList[position]
        with(viewHolder)
        {
            id?.text = item.id.toString()
            name?.text = item.name
            container?.setOnClickListener { cellClick.onStudentClick(position, item) }
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var id: TextView? = itemView.findViewById(R.id.id)
        var name: TextView? = itemView.findViewById(R.id.name)
        var container: RelativeLayout? = itemView.findViewById(R.id.container)
    }

    interface StudentClickListener {
        fun onStudentClick(position: Int, itemAtPos: StudentModel)
    }


}