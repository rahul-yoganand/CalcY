package com.example.calcy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

lateinit  var username:EditText
lateinit var passwd:EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username=findViewById(R.id.tvUserName)
        passwd=findViewById(R.id.tvPasswd)

    }

    fun loginCheck(view: View) {
        if(username.text.toString()=="admin" && passwd.text.toString()=="admin"){
            var cintent = Intent(this,calculator::class.java)
            Toast.makeText(this,R.string.login_success,Toast.LENGTH_SHORT).show()
            startActivity(cintent)
        }else {
            Toast.makeText(this,R.string.login_fail,Toast.LENGTH_LONG).show()
        }

    }
}