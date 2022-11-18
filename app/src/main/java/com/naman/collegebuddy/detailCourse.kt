package com.naman.collegebuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class detailCourse : AppCompatActivity() {

    private lateinit var adapter2: MyAdapter2
    private lateinit var semrecyclerView: RecyclerView
    private lateinit var semsArrayList: ArrayList<Semester>

    lateinit var semester: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)


        semester= arrayOf(
            "Semester 1",
            "Semester 2",
            "Semester 3",
            "Semester 4",
            "Semester 5",
            "Semester 6",
            "Semester 7",
            "Semester 8"
        )


        semrecyclerView = findViewById(R.id.recyclerview2)
        semrecyclerView.layoutManager = LinearLayoutManager(this)
        semrecyclerView.setHasFixedSize(true)

        semsArrayList = arrayListOf<Semester>()
        getUserdata()
    }

    private fun getUserdata() {
        for(i in semester.indices) {
            val semester = Semester(semester[i])
            semsArrayList.add(semester)
        }

        var adapter = MyAdapter2(semsArrayList)
        semrecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : MyAdapter2.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomePage,"You clicked on item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@detailCourse,Syllabus::class.java)
                startActivity(intent)

            }
        })
    }
}
