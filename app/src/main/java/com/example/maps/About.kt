package com.example.maps

/**
 * Activity for containing the about us and credits fragments.
 * Also has link to Settings activity.
 * @author Kavan Chay
 *
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ArrayAdapter

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val ourList = arrayOf("Settings","About us","Credits")
        val ourListView = findViewById<ListView>(R.id.screenListView)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ourList)
        ourListView.adapter = adapter

        ourListView.setOnItemClickListener{parent, view, position, id ->

            // Upon click, this will go to Settings activity.
            if (position==0){

            }
            // Upon click, this will go to About Us fragment.
            if (position==1){

            }
            // Upon click, this will go to Credits fragment.
            if (position==2){

            }

        }

    }
}