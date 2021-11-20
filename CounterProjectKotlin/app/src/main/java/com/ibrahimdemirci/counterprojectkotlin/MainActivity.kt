package com.ibrahimdemirci.counterprojectkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Abstract Class

        // Abstract class have not object
        //        val myTimer = CountDownTimer()

        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                textView.text = "Last : ${millisUntilFinished/1000}"

            }

            override fun onFinish() {

                textView.text = "Last : 0"
            }

        }.start()



    }
}