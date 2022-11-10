
package com.naman.collegebuddy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_Activity : AppCompatActivity() {

    lateinit var btnusrnme: EditText
    lateinit var btnpsswrd: EditText
    lateinit var btnlogin: Button
    lateinit var btnForgotPsswrd: Button

    val validusername = "namanjainbr@gmail.com"
    val validpassword = "6203511374"
    lateinit var sharedPreferences: SharedPreferences;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name),MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)

        setContentView(R.layout.login_activity)

        if(isLoggedIn){
            val intent= Intent(this@login_Activity,HomePage::class.java)
            startActivity(intent)
            finish()
        }else{
            setContentView(R.layout.login_activity)
        }

        setContentView(R.layout.login_activity)

        title = "Login Page"

        btnusrnme = findViewById(R.id.btnusrnme)
        btnpsswrd = findViewById(R.id.btnpsswrd)
        btnlogin = findViewById(R.id.btnlogin)
        btnForgotPsswrd = findViewById(R.id.btnForgotPsswrd)

        btnlogin.setOnClickListener {

            val username = btnusrnme.text.toString()

            val password = btnpsswrd.text.toString()

            var nameOfAvenger = "Avenger"

            val intent = Intent(this@login_Activity,HomePage::class.java)

            if ((username == validusername )) {

                when (password) {
                    validpassword -> {
                        startActivity(intent)

                    }

                    else -> Toast.makeText(this@login_Activity, "Incorrect Password", Toast.LENGTH_LONG).show()
                }

            } else {

                Toast.makeText(this@login_Activity, "Incorrect Credentials", Toast.LENGTH_LONG).show()

            }
        }

        btnForgotPsswrd.setOnClickListener{
            val intent = Intent(this@login_Activity,RegisterYourself::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }





}