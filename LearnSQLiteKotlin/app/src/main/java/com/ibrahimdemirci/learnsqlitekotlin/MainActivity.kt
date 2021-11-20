package com.ibrahimdemirci.learnsqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // try-catch

        try {

            val database = this.openOrCreateDatabase("products", MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY, name VARCHAR , price INT)")
//            database.execSQL("INSERT INTO products (name,price) VALUES ('Coat',120)")
//            database.execSQL("INSERT INTO products (name,price) VALUES ('Dress',150)")
//            database.execSQL("INSERT INTO products (name,price) VALUES ('Car',87000)")
//            database.execSQL("INSERT INTO products (name,price) VALUES ('PC',5500)")


//            val cursor = database.rawQuery("SELECT * FROM products WHERE name = 'Car'",null)
//            val cursor = database.rawQuery("SELECT * FROM products WHERE id >2 ",null)
//            val cursor = database.rawQuery("SELECT * FROM products WHERE name LIKE '%a%' ",null)

//            database.execSQL("DELETE FROM products WHERE id = 5")
//            database.execSQL("UPDATE  products SET price = 90000 WHERE name = 'Car'")

            val cursor = database.rawQuery("SELECT * FROM products",null)


            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val priceIndex = cursor.getColumnIndex("price")

            while (cursor.moveToNext()){
                println("ID : ${cursor.getInt(idIndex)}")
                println("NAME : ${cursor.getString(nameIndex)}")
                println("PRICE : ${cursor.getInt(priceIndex)}")
            }

            cursor.close()


        }catch (e: Exception){

            e.printStackTrace()

        }
    }
}