package com.naman.collegebuddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter2(private val semslist: java.util.ArrayList<Semester>): RecyclerView.Adapter<MyAdapter2.MyViewHolder2>() {

    private lateinit var mListener1: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener1 = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder2 {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.sems_list, parent,
            false
        )
        return MyViewHolder2(itemView, mListener1)
    }

    override fun onBindViewHolder(holder: MyViewHolder2, position: Int) {

        val currentItem = semslist[position]
        holder.txtSemester.text = currentItem.Semester

    }

    override fun getItemCount(): Int {
        return semslist.size
    }

    class MyViewHolder2(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val txtSemester: TextView = itemView.findViewById(R.id.txtSemester)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}