package com.naman.collegebuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Syllabus : AppCompatActivity() {
    private lateinit var adapter3: MyAdapter3
    private lateinit var sylbusrecyclerView: RecyclerView
    private lateinit var sylbusArrayList: ArrayList<syllabusd>

    lateinit var syllabus: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syllabus)


        syllabus = arrayOf(
            "Discrete Mathematics",
            "Introductory Topics in Statistics, Probability and calculus",
            "Fundamental of Computer Science",
            "Principles of Electrical Engineering",
            "Physics for Computing Science",
            "Business Communication & Value Science - I",
            "Fundamental of Computer Science Lab",
            "Principles of Electrical Engineering lab",
            "Physics for Computing Science lab",
            "Life Skills & Mentoring(MNG)"
        )


        sylbusrecyclerView = findViewById(R.id.recyclerview3)
        sylbusrecyclerView.layoutManager = LinearLayoutManager(this)
        sylbusrecyclerView.setHasFixedSize(true)

        sylbusArrayList = arrayListOf<syllabusd>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in syllabus.indices) {
            val syllabus1 = syllabusd(syllabus[i])
            sylbusArrayList.add(syllabus1)
        }

        var adapter = MyAdapter3(sylbusArrayList)
        sylbusrecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : MyAdapter3.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomePage,"You clicked on item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@Syllabus,detail_syllabus::class.java)
                startActivity(intent)

            }
        })
    }
}