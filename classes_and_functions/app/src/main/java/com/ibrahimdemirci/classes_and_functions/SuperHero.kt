package com.ibrahimdemirci.classes_and_functions

class SuperHero(var name: String, var business: String, var old: Int) {


    // Access Levels
    // private - protected - internal - public

    private var hairColor = "Yellow"


     fun testFunction(){
        println("Test")

    }

    // Getter
    fun getHairColor(): String{
        return this.hairColor
    }

    // Setter

    fun  setHairColor(){
        this.hairColor = "Green"
    }




    // Constructor

//    constructor(name:String,business:String,old:Int){
//
//        this.name = name
//        this.business = business
//        this.old = old
//
//    }


}