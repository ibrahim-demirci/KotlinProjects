package com.ibrahimdemirci.learn_kotlin_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // Strings
        println("----------String----------")

        val newStr = "My new string"

        println(newStr.length)

        val name = "Ibrahim"
        val surname = "Demirci"

        val fullName = name + " " +surname
        val fullName2 = "$name $surname"
        println(fullName)
        println(fullName2)


        val newString2 : String = "10"

        val otherString = "20"
        println(otherString+newString2)




        // Boolean
        println("----------Boolean----------")

        var myBool = true
        myBool = false

        // <
        // >
        // == equal
        // != not equal
        // <= >=
        // && || and or

        println(3<5)
        println(4!=4)


        // Type Conversion
        println("----------Type Conversion----------")

        val myInt = 10

        val myLongInt = myInt.toLong()
        println(myLongInt)


        val userInput = "50"
        val userInputInt = userInput.toInt()

        println(userInputInt/2)

        // Collections Struct Types
        // Arrays

        val expString = "Atil"
        val myArray = arrayOf("Ibrahim","Demirci","Kerem","Osman",expString)

        //index
        println(myArray[0])
        println(myArray.get(1))
        myArray[2] = "Keremiko"
        println(myArray.get(2))

        myArray.set(0,"NewIbrahim")
        println(myArray.get(0))

        val numArray = doubleArrayOf(1.0,2.0,3.4)
        println(numArray.get(2))

        val mixArray = arrayOf("Atil","24",16.5,true,false)
        println(mixArray.get(3))


        // ArrayList

        // arrayListOf() böyle bırakılamaz. Bos ise <> gerekli olur.


        val nameList = arrayListOf<String>("Atil","Zeynep","Osman")

        println(nameList.get(0))
        println(nameList[0])

        // Sonradan ekleme olayı.
        nameList.add("Ibrahim")
        nameList.add("Mehmet")


        val mixArrayList = arrayListOf<Any>()
        // arrayListOf<String>() ise mixArrayList.add(3) islemi yapilamaz.
        mixArrayList.add(3)
        mixArrayList.add(true)
        mixArrayList.add("Str")

        // Baska bir tanimlama tarzi.
        val intArrayList = ArrayList<Int>()
        intArrayList.add(5)
        intArrayList.add(20)
        println(intArrayList.get(1))


        // Set Structure

        // Duplication olamaz.

        val sampleArray = arrayOf(7,8,9,9,9,8,10)
        println("index 2: ${sampleArray[2]}")
        println(sampleArray.size)

        val mySet = setOf<Int>(7,8,9,9,9,8,10)
        println(mySet.size)


        // ForEach loop.
        mySet.forEach {
            println(it)
        }

        val otherSet = HashSet<String>()

        otherSet.add("Atil")
        otherSet.add("Atil")
        otherSet.add("Atil")
        otherSet.add("Samancioglu")


        otherSet.forEach {
            println(it)
        }


        // Map Structure

        // Key-Value Pairing

        val foodCalorieMap = hashMapOf<String,Int>()
        foodCalorieMap.put("Elma",100)
        foodCalorieMap["Et"] = 300

        println(foodCalorieMap.get("Et"))
        println(foodCalorieMap["Elma"])

        // Diger tanimlama tarzi.
        val myMap = HashMap<String,String>()
        myMap.put("Exp","Value")


        val newMap = hashMapOf<String,Int>("Atil" to 40,"Ibrahim" to 50)
        println(newMap.get("Ibrahim"))

        // Mathematics in Kotlin

        var num = 8
        println(num)

        num = num+1
        println(num)

        num++
        println(num)

        num--
        println(num)

        val otherNum = 10
        println(otherNum>num)

        // && and operator || or operator

        println(otherNum>num && 2>3)
        println(otherNum>num || 2>3)

        // Remainder
        println(10%3)
        println(10%2)



        // If statements

        val score = 10

        if(score<10){
            println("Lose")
        }else if(score<20){
            println("Not bad")
        }else{
            println("Congratulations")
        }


        // When Structure

        val schoolScore = 0
        var scoreString = ""



//        if(schoolScore == 0){
//            scoreString= "Gecersiz"
//        }else if(schoolScore == 1){
//            scoreString = "Zayıf"
//        }else if(schoolScore == 2){
//            scoreString = "Orta"
//        }else if(schoolScore == 3){
//            scoreString = "Iyi"
//        }else {
//            scoreString = "Super"
//        }

        scoreString = when(schoolScore){

            0 -> "Gecersiz"
            1 -> "Zayıf"
            2 -> "Orta"
            3 -> "Iyi"
            else -> "Super"

        }

        println(scoreString)


        // For Loop

        val numArray1 = arrayOf(3,5,6,7,4);

        for(n in numArray1){
            println(n)
        }
        for(n in numArray1.indices){
            println(numArray1[n])
        }

        for (i in 0..9){
            println(i)
        }

        val myStringArrayList = ArrayList<String>();

        myStringArrayList.add("Atil")
        myStringArrayList.add("Samanci")

        for(str in myStringArrayList){
            println(str)
        }

        myStringArrayList.forEach{
            println(it)
        }

        // While Loop

        var index = 0

        while(index<10){
            println("index: $index")
            index ++
        }

















    }
}