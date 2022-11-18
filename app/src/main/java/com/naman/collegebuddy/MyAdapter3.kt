package com.naman.collegebuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter3(private val syllabuslist: java.util.ArrayList<syllabusd>): RecyclerView.Adapter<MyAdapter3.MyViewHolder3>() {

    private lateinit var mListener2: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener2 = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder3 {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.syllabus_list, parent,
            false
        )
        return MyViewHolder3(itemView, mListener2)
    }

    override fun onBindViewHolder(holder: MyViewHolder3, position: Int) {

        val currentItem = syllabuslist[position]
        holder.txtSyllabus.text = currentItem.Syllabus

    }

    override fun getItemCount(): Int {
        return syllabuslist.size
    }

    class MyViewHolder3(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val txtSyllabus: TextView = itemView.findViewById(R.id.txtSyllabus)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}