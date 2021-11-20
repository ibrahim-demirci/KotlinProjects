package com.ibrahimdemirci.otheractivitiesinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        val intent = intent.getStringExtra("data")

        textView2.text = intent
    }


    fun goBack(view: View){

        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
        finish()


    }


}