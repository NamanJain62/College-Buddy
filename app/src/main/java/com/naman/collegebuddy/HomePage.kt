package com.naman.collegebuddy

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HomePage : AppCompatActivity() {
    var titleName: String? = "The Avengers"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name),MODE_PRIVATE)
        setContentView(R.layout.activity_home_page)

        titleName = sharedPreferences.getString("Title","College Buddy")

        title = titleName
    }
}