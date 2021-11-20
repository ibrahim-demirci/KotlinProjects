package com.ibrahimdemirci.superherobookkotlinproject

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerAdapter(val superHeroList : ArrayList<String>, val heroImageIDs : ArrayList<Int> ) :RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>(){

    class SuperHeroVH(itemView: View) :RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {

        // Inflater, LayoutInflater, MenuInflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return SuperHeroVH(itemView)

    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {

        holder.itemView.recyclerViewTextView.text = superHeroList[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("superHeroName",superHeroList[position])

            intent.putExtra("superHeroImage",heroImageIDs[position])

            /*
            val singleton = SingletonClass.SelectedHero
            singleton.image = heroImages[position]
               */



            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return superHeroList.size;

    }
}