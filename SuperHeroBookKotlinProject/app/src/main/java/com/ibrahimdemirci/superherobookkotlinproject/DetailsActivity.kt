package com.ibrahimdemirci.superherobookkotlinproject

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        
        
        
        val intent = intent
        val selectedName = intent.getStringExtra("superHeroName")

        textView.text = selectedName

        val selectedHeroImage = intent.getIntExtra("superHeroImage",0)
        val bitmap = BitmapFactory.decodeResource(applicationContext.resources,selectedHeroImage)

        imageView.setImageBitmap(bitmap)


    /*
        val selectedHero = SingletonClass.SelectedHero
        val selectedImage = selectedHero.image


        imageView.setImageBitmap(selectedImage)

    */
    }
}