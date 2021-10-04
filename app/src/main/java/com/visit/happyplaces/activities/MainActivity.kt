package com.visit.happyplaces.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.visit.happyplaces.R
import com.visit.happyplaces.adapters.HappyPlacesAdapter
import com.visit.happyplaces.database.DatabaseHandler
import com.visit.happyplaces.models.HappyPlaceModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabAddHappyPlace=findViewById<FloatingActionButton>(R.id.fabAddHappyPlace)

        fabAddHappyPlace.setOnClickListener{
            val intent=Intent(this, AddHappyPlaceActivity::class.java)
            startActivityForResult(intent,ADD_PLACE_ACTIVITY_REQUEST_CODE)
        }
        getHappyPlaceListFromLocalDB()
    }

    private fun setupHappyPlacesRecyclerView(happyPlaceList:ArrayList<HappyPlaceModel>){
        rv_happy_places_list.layoutManager=LinearLayoutManager(this)
        rv_happy_places_list.setHasFixedSize(true)
        val placesAdapter = HappyPlacesAdapter(this,happyPlaceList)
        rv_happy_places_list.adapter=placesAdapter
    }

    private fun getHappyPlaceListFromLocalDB(){
        val dbHandler=DatabaseHandler(this)
        val getHappyPlaceList = dbHandler.getHappyPlacesList()
        if(getHappyPlaceList.size>0){
            rv_happy_places_list.visibility= View.VISIBLE
            tv_no_record_available.visibility=View.GONE
            setupHappyPlacesRecyclerView(getHappyPlaceList)
        }
        else{
            rv_happy_places_list.visibility= View.GONE
            tv_no_record_available.visibility=View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== ADD_PLACE_ACTIVITY_REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){
                getHappyPlaceListFromLocalDB()
            }
            else{
                Log.e("Activity","Back pressed or not added")
            }
        }
    }

    companion object{
        var ADD_PLACE_ACTIVITY_REQUEST_CODE=1
    }

}