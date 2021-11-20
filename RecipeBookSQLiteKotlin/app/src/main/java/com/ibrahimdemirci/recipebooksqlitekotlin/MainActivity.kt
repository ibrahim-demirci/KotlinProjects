package com.ibrahimdemirci.recipebooksqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.deleteDatabase("Foods");

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_food,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.add_food_item){

            val action = ListFragmentDirections.actionListFragmentToRecipeFragment("menu",0)
            Navigation.findNavController(this,R.id.fragment).navigate(action)

        }

        return super.onOptionsItemSelected(item)
    }
}