package com.ibrahimdemirci.fragmentkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun firstFragment(view:View){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val firstBlank = BlankFragment()
        fragmentTransaction.replace(R.id.frameLayout,firstBlank).commit()


    }
    fun secondFragment(view:View){


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val secondBlank = BlankFragment2()
        fragmentTransaction.replace(R.id.frameLayout,secondBlank).commit()
    }
}