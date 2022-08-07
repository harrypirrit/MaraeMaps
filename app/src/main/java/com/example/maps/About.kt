package com.example.maps

/**
 * Activity for containing the about us, settings and other fragments.
 *
 * @author Kavan Chay
 *
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }
}