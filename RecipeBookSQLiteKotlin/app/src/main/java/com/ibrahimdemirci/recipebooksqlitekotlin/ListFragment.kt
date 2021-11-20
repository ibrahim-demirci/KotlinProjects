package com.ibrahimdemirci.recipebooksqlitekotlin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {


    var foodNameList = ArrayList<String>()
    var foodIDList = ArrayList<Int>()

    private lateinit var listAdapter : ListRecyclerAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listAdapter = ListRecyclerAdapter(foodNameList,foodIDList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter
        getDatasFromSQL()
    }


    fun getDatasFromSQL(){

            try {

                activity?.let {
                    val database = it.openOrCreateDatabase("Foods", Context.MODE_PRIVATE,null)

                    val cursor = database.rawQuery("SELECT * FROM foods",null)
                    val foodNameIndex = cursor.getColumnIndex("foodName")
                    val idIndex = cursor.getColumnIndex("id")


                    foodNameList.clear()
                    foodIDList.clear()

                    while(cursor.moveToNext()){

                        foodNameList.add(cursor.getString(foodNameIndex))
                        foodIDList.add(cursor.getInt(idIndex))

                    }

                    listAdapter.notifyDataSetChanged()
                    cursor.close()
                }



        }catch (e:Exception){



        }


    }


}