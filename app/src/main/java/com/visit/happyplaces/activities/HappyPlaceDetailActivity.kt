package com.visit.happyplaces.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import com.visit.happyplaces.R

class HappyPlaceDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_place_detail)

        val toolbar_add_place=findViewById<Toolbar>(R.id.toolbar_detail_happy_place)

        setSupportActionBar(toolbar_add_place)
        val actionBar=supportActionBar

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title="Happy Place Details"
        toolbar_add_place.setNavigationOnClickListener{
            onBackPressed()
        }

    }

}