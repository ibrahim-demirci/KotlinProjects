package com.ibrahimdemirci.superherobookkotlinproject

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Prepare Data

        var superHeroNames = ArrayList<String>()

        superHeroNames.add("Batman")
        superHeroNames.add("Aquaman")
        superHeroNames.add("Spiderman")
        superHeroNames.add("Iron Man")
        superHeroNames.add("Superman")

        // Inefficient Define
        /*
        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.batman)
        val aquamanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.aquaman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.spiderman)
        val ironmanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.ironman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.superman)


        var superHeroImages = ArrayList<Bitmap>()
        superHeroImages.add(batmanBitmap)
        superHeroImages.add(aquamanBitmap)
        superHeroImages.add(spidermanBitmap)
        superHeroImages.add(ironmanBitmap)
        superHeroImages.add(supermanBitmap)

        */

        // Efficient Defines
        val batmanDraweableId = R.drawable.batman
        val aquamanDraweableId = R.drawable.aquaman
        val spidermanDraweableId = R.drawable.spiderman
        val ironmanDraweableId = R.drawable.ironman
        val supermanDraweableId = R.drawable.superman

        val superHeroImageIDs = ArrayList<Int>()

        superHeroImageIDs.add(batmanDraweableId)
        superHeroImageIDs.add(aquamanDraweableId)
        superHeroImageIDs.add(spidermanDraweableId)
        superHeroImageIDs.add(ironmanDraweableId)
        superHeroImageIDs.add(supermanDraweableId)



        // Adapter

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = RecyclerAdapter(superHeroNames,superHeroImageIDs);
        recyclerView.adapter = adapter





    }
}