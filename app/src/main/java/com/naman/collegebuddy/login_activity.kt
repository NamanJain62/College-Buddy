
package com.naman.collegebuddy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class login_activity : AppCompatActivity() {

    lateinit var btnusrnme: EditText
    lateinit var btnpsswrd: EditText
    lateinit var btnlogin: Button
    lateinit var txtForgotPsswrd: TextView

    val validusrnme = "namanjainbr@gmail.com"
    val validpsswrd = "6203511374"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name),
            Context.MODE_PRIVATE
        )

        if(sharedPreferences.getBoolean("isLoggedIn",false)){
            val intent = Intent(this@login_activity,HomePage::class.java)
            startActivity(intent)
            finish()
        }else {
            setContentView(R.layout.login_activity)
        }

        title = "Login Page"

        btnusrnme = findViewById(R.id.btnusrnme)
        btnpsswrd = findViewById(R.id.btnpsswrd)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {

            var name = "College Buddy"
            val username = btnusrnme.text.toString()
            val password = btnpsswrd.text.toString()
            val intent = Intent(this@login_activity, HomePage::class.java)

            if ((username == validusrnme)) {

                when (password) {
                    validpsswrd -> {
                        name = "Naman Jain"
                        intent.putExtra("Name", name)
                        startActivity(intent)
                        finish()
                    }
                    else -> Toast.makeText(this@login_activity, "Correct Password", Toast.LENGTH_LONG).show()
                }

            } else {

                Toast.makeText(this@login_activity, "Incorrect Credentials", Toast.LENGTH_LONG).show()

            }

        }
    }




}