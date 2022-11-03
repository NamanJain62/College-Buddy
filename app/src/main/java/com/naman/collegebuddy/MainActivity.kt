package com.naman.collegebuddy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.Timer
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

        Handler().postDelayed({val intent = Intent(this@MainActivity, login_Activity::class.java)
            startActivity(intent)
            finish()
                              },2000)
    }
}