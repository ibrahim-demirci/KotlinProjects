package com.ibrahimdemirci.classes_and_functions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {


    // This runs before the screen shows
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val j = 0;

        if(j == 0){
            firstFunction()
        }else {
            secondFunction()
        }

//        subtraction(10,20)
//        println(addition(3,5))


        button.setOnClickListener{
            val sumResult = addition(10,50)
            textView.text = "Result : $sumResult"
        }

//        classWorks()
        nullSafety()


    }



    private fun firstFunction ()
    {
        println("First func called")
    }

    private fun secondFunction ()
    {
        println("Second func called")
    }

    // Get Input

    private fun subtraction(x:Int, y:Int) {

        if (x > y) {
            textView.text = "Result : ${x - y}"
        } else {
            textView.text = "Result : ${y - x}"
        }

    }


    // Return Value

    fun addition(a:Int,b:Int):Int{

        return a+b


    }
     /*
     *  fun changeText(view: View){

        val sumResult = addition(10,50)
        textView.text = "Result : $sumResult"

    }
     * */

    fun classWorks(){

        val superman = SuperHero("Superman","Journalit",55)
        superman.testFunction()
        println(superman.getHairColor())
        textView.text = "Name : ${superman.name}"

    }

    fun nullSafety(){

        // Null, Nullability, Null Safety

        var myString : String?


        // Initialization
        myString = "Atil"

        var myAge :Int?= null
        println(myAge)

        //1
        if(myAge != null){
            println(myAge*2)
        }else {
            println("Null value")
        }

        //2
        // !! -> not null, ? -> can be null
        // throws nullPointerException

        println(myAge?.minus(2))

        //3
        // elvis operator
        // if value is null assign the value near ?:
        val result = myAge?.minus(2) ?: 10
        println(result)

        //4

        myAge?.let {
            println(it*5)
        }


        



    }





}