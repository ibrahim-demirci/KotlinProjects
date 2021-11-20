package com.ibrahimdemirci.kotlinlearncontextproject

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast Alert

        // applicationContext -> app context
        // this, this@MainActivity - activity context


        Toast.makeText(this,"Hello",Toast.LENGTH_LONG).show()



    }




    fun showMessage(view:View){


        val alertMessage = AlertDialog.Builder(this)
        alertMessage.setTitle("Warning")
        alertMessage.setPositiveButton("OK",DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(this,"OK Clicked",Toast.LENGTH_LONG).show()


        })

        alertMessage.setNegativeButton("Cancel") {dialogInterface,i ->

            Toast.makeText(this,"Cancel Clicked",Toast.LENGTH_LONG).show()
        }



        alertMessage.show()
    }
}