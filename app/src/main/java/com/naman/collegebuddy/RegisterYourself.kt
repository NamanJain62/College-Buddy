package com.naman.collegebuddy

import android.content.Intent
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registeryourself)
        txtname = findViewById(R.id.txtname)
        txtusername = findViewById(R.id.txtusername)
        etxtpassword = findViewById(R.id.etxtpassword)
        etxtCfrmpaasword = findViewById(R.id.etxtCfrmpaasword)
        btnsignup =findViewById(R.id.btnsignup)

        btnsignup.setOnClickListener() {
            var txtnameValue = txtname.text.toString()
            val txtusername = txtusername.text.toString()
            val etxtpassword = etxtpassword.text.toString()
            val etxtCfrmpassword = etxtCfrmpaasword.text.toString()
            val intent = Intent(this@RegisterYourself, HomePage::class.java)

        }
    }
}