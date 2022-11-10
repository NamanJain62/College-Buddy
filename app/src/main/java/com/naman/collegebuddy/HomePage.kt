package com.naman.collegebuddy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomePage : AppCompatActivity() {
    var titleName: String? = "College Buddy"

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: java.util.ArrayList<Course>
    lateinit var imageId : Array<Int>
    lateinit var heading: Array<String>
    lateinit var Course : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        imageId = arrayOf(
          R.drawable.csbs,
          R.drawable.dsa,
          R.drawable.bda1,
          R.drawable.cs,
          R.drawable.cs,
          R.drawable.cs
        )

        heading= arrayOf(
            "Computer Science and Business System  (Dpecialization course)",
            "Data Structure And Algorithm  (Placement Drive)",
            "Big-Data Analyst  (Specialization course)",
            "-------------","-------------","-------------"
        )


        newRecyclerView = findViewById(R.id.recyclerview)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Course>()
        getUserdata()

    }

    private fun getUserdata() {
        for(i in imageId.indices) {
            val course = Course(imageId[i], heading[i])
            newArrayList.add(course)
        }

        var adapter = MyAdapter(newArrayList)
        newRecyclerView.adapter= adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //Toast.makeText(this@HomePage,"You clicked on item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@HomePage,detailCourse::class.java)
                startActivity(intent)

            }
        })
    }
}