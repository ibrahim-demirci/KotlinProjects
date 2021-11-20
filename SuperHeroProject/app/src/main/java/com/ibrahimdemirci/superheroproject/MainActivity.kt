package com.ibrahimdemirci.superheroproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun saveHero(view:View){

        val name = nameText.text.toString()
        val business = businessText.text.toString()
        val age = ageText.text.toString().toIntOrNull()


        if(age == null){
            textView.text = "Please enter digit age"
        }else{
            var hero = SuperHero(name,age,business)
            textView.text = "Name: $name Business : $business Age : $age"

        }






    }
}