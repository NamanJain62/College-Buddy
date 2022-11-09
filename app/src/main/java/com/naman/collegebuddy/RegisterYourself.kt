package com.naman.collegebuddy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterYourself : AppCompatActivity() {

    lateinit var txtname: EditText
    lateinit var txtusername: EditText
    lateinit var etxtpassword: EditText
    lateinit var etxtCfrmpaasword: EditText
    lateinit var btnsignup: Button
    lateinit var sharedPreferences: SharedPreferences




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeryourself)
        txtname = findViewById(R.id.txtname)
        txtusername = findViewById(R.id.txtusername)
        etxtpassword = findViewById(R.id.etxtpassword)
        etxtCfrmpaasword = findViewById(R.id.etxtCfrmpaasword)
        btnsignup =findViewById(R.id.btnsignup)

        sharedPreferences = getSharedPreferences(getString(R.string.preferences_file_name),0)

        btnsignup.setOnClickListener() {
            var txtnameValue = txtname.text.toString()
            val txtusernameValue = txtusername.text.toString()
            val etxtpasswordValue = etxtpassword.text.toString()
            val etxtCfrmpasswordValue = etxtCfrmpaasword.text.toString()
            val intent = Intent(this@RegisterYourself, HomePage::class.java)

            sharedPreferences.edit().putString("name",txtnameValue).apply();
            sharedPreferences.edit().putString("mail",txtusernameValue).apply();
            sharedPreferences.edit().putString("password",etxtpasswordValue).apply();
            sharedPreferences.edit().putString("Cfrmpassword",etxtCfrmpasswordValue).apply();
            sharedPreferences.edit().putBoolean("login",true).apply();


        }
    }
}