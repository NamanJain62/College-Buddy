package com.naman.collegebuddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class detail_syllabus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_syllabus)

        val unit1 : TextView = findViewById(R.id.txtunit1)
        val unit2 : TextView = findViewById(R.id.txtunit2)
        val unit3 : TextView = findViewById(R.id.txtunit3)

        val descd1 : TextView = findViewById(R.id.desc1)
        val descd2 : TextView = findViewById(R.id.desc2)
        val descd3 : TextView = findViewById(R.id.desc3)

        val bundle : Bundle?= intent.extras
        val desc1 = bundle!!.getString("desc1")
        val desc2 = bundle.getString("desc2")
        val desc3 = bundle.getString("desc3")

        descd1.text = desc1
        descd2.text = desc2
        descd3.text = desc3

    }
}