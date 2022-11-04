
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

    val validusrnme = "namanjainbr@gmail.com"
    val validpsswrd = "6203511374"
    lateinit var sharedPreferences: SharedPreferences

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

        btnlogin.setOnClickListener {

            var name = "College Buddy"
            val username = btnusrnme.text.toString()
            val password = btnpsswrd.text.toString()
            val intent = Intent(this@login_Activity, HomePage::class.java)

            if ((username == validusrnme)) {

                when (password) {
                    validpsswrd -> {
                        name = "Naman Jain"
                        savePreferences(name)
                        intent.putExtra("Name", name)
                        startActivity(intent)
                    }
                    else -> Toast.makeText(this@login_Activity, "InCorrect Password", Toast.LENGTH_LONG).show()
                }

            } else {

                Toast.makeText(this@login_Activity, "InCorrect Passw,ord", Toast.LENGTH_LONG).show()

            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putString("title",title).apply()
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }




}