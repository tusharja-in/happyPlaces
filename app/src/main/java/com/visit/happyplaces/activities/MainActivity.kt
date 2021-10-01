package com.visit.happyplaces.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.visit.happyplaces.R
import com.visit.happyplaces.database.DatabaseHandler
import com.visit.happyplaces.models.HappyPlaceModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddHappyPlace=findViewById<FloatingActionButton>(R.id.fabAddHappyPlace)

        fabAddHappyPlace.setOnClickListener{
            val intent=Intent(this, AddHappyPlaceActivity::class.java)
            startActivity(intent)
        }
        getHappyPlaceListFromLocalDB()
    }

    private fun getHappyPlaceListFromLocalDB(){
        val dbHandler=DatabaseHandler(this)
        val getHappyPlaceList:ArrayList<HappyPlaceModel> = dbHandler.getHappyPlacesList()

        //Log.e("size",getHappyPlaceList.size.toString())
    }

}