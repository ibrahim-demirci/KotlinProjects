package com.ibrahimdemirci.recipebooksqlitekotlin

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_recipe.*
import java.io.ByteArrayOutputStream
import java.lang.Exception


class RecipeFragment : Fragment() {


    var foodNameList = ArrayList<String>()
    var foodIdList = ArrayList<String>()



    private var selectedImage : Uri? = null
    private var selectedBitmap : Bitmap? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            save(it)

        }

        imageView.setOnClickListener{
            selectImage(it)
        }

        val new = 5
        val new1 = 2

        println(new/new1)

        arguments?.let {

            var information = RecipeFragmentArgs.fromBundle(it).information
            if(information.equals("menu")){

                // new food
                editText.setText("")
                editText1.setText("")
                button.visibility = View.VISIBLE

                var selectImageBackground = BitmapFactory.decodeResource(context?.resources,R.drawable.click)
                imageView.setImageBitmap(selectImageBackground)


            }else {


                button.visibility = View.INVISIBLE
                val selectedID = RecipeFragmentArgs.fromBundle(it).id

                context?.let {

                    try {

                        var db = it.openOrCreateDatabase("Foods",Context.MODE_PRIVATE,null)
                        val cursor = db.rawQuery("SELECT * FROM foods WHERE id = ?", arrayOf(selectedID.toString()))


                        val foodName = cursor.getColumnIndex("foodName")
                        val foodMaterials = cursor.getColumnIndex("foodMaterials")
                        val image = cursor.getColumnIndex("image")

                        while (cursor.moveToNext()){

                            editText.setText(cursor.getString(foodName))
                            editText1.setText(cursor.getString(foodMaterials))

                            val byteArray = cursor.getBlob(image)
                            val bitmap = BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)
                            imageView.setImageBitmap(bitmap)





                        }

                        cursor.close()

                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }



            }
        }
    }
    private fun save(view:View){

        // Save to SQLite
        var foodName = editText.text.toString()
        val foodMaterials = editText1.text.toString()

        if(selectedBitmap != null){

            val smallBitmap = createSmallSizeBitmap(
                selectedBitmap!!,300)
            val outputStream = ByteArrayOutputStream()
            smallBitmap.compress(Bitmap.CompressFormat.PNG,50,outputStream)
            val byteArray = outputStream.toByteArray()


            try {

                context?.let {

                    val database = it.openOrCreateDatabase("Foods",Context.MODE_PRIVATE,null)
                    database.execSQL("CREATE TABLE IF NOT EXISTS foods (id INTEGER PRIMARY KEY, foodName VARCHAR, foodMaterials VARCHAR ,image  BLOB)")

                    val sqlString = "INSERT INTO foods (foodName ,foodMaterials,image) VALUES (?,?,?)"
                    val statement = database.compileStatement(sqlString)
                    statement.bindString(1,foodName)
                    statement.bindString(2,foodMaterials)
                    statement.bindBlob(3,byteArray)
                    statement.execute()

                }

            }catch (e:Exception){

                e.printStackTrace()
            }

            val action = RecipeFragmentDirections.actionRecipeFragmentToListFragment()
            Navigation.findNavController(view).navigate(action)

        }



    }
    private fun selectImage(view:View){

        activity?.let {
            // ContextCompat because API19 before or after is available
            if(ContextCompat.checkSelfPermission(it.applicationContext,
                    Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                // Permission is not active
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1)

            }else {

                // Permission is active
                val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent,2)

            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if(requestCode ==1){

            if(grantResults.size > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // Access verified
                val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent,2)

            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            selectedImage = data.data

            try {
                context?.let {

                    if(selectedImage != null ){

                        if(Build.VERSION.SDK_INT >= 28){
                            val source = ImageDecoder.createSource(it.contentResolver,selectedImage!!)
                            selectedBitmap = ImageDecoder.decodeBitmap(source)
                            imageView.setImageBitmap(selectedBitmap)

                        }else {

                            selectedBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver,selectedImage)

                        }
                    }
                }
            }catch (e: Exception){

                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }



    fun createSmallSizeBitmap(selectedBitmap : Bitmap,maxSize:Int) : Bitmap{

        var width = selectedBitmap.width
        var height = selectedBitmap.height

        val bitmapRatio : Double = width.toDouble() / height.toDouble()

        if(bitmapRatio >1){
            // horizontal
            width = maxSize
            val decreasedHeight = width/bitmapRatio
            height = decreasedHeight.toInt()

        }else {
            //vertical
            height = maxSize
            val decreasedWidth = height*bitmapRatio
            width = decreasedWidth.toInt()

        }

        return Bitmap.createScaledBitmap(selectedBitmap,width,height,true)
    }

}