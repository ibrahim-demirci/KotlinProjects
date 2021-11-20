package com.ibrahimdemirci.otheractivitiesinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("onCreate Called")


    }

    override fun onStart() {
        super.onStart()
        println("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        println("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        println("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        println("onStopCalled")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy Called")
    }


    fun goSecondActivity(view:View){

        val data = editText.text.toString()

        val intent = Intent(applicationContext,SecondActivity::class.java)
        intent.putExtra("data",data)
        startActivity(intent)
        finish()


    }
}