package com.ibrahimdemirci.sharedpreferenceskotlin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPreferences : SharedPreferences
    var savedUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = this.getSharedPreferences("sharedpreferenceskotlin", MODE_PRIVATE,)
        savedUserName = sharedPreferences.getString("userName","Nothing")

        if(savedUserName != null){
            textView.text = "Name : $savedUserName"
        }

    }


    // SharedPreferences
    fun save(view:View){

        val name = editText.text.toString()

        if(name.isEmpty()){
            Toast.makeText(this,"Enter different null ",Toast.LENGTH_LONG).show()
        } else {
            sharedPreferences.edit().putString("userName",name).apply()
            textView.text = "Name : $name"

        }


    }

    fun delete(view:View){

        savedUserName = sharedPreferences.getString("userName","")

        if(savedUserName != null){
            textView.text = "Name : "
            sharedPreferences.edit().remove("userName").apply()
        }


    }



    }

