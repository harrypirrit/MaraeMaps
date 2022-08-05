package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.os.Environment
import com.example.maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.BufferedReader
import java.io.FileReader
import java.io.InputStreamReader
import java.nio.Buffer
import java.nio.file.Paths
import kotlin.io.path.Path

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val bufferedReader = InputStreamReader(assets.open("Marae.csv")).buffered()
        val maraeData = getMaraeData(bufferedReader)

        // Create a Marae instance at Te Uru
        // Marae(name: String, wharenui: String, X: Double, Y: Double, location: String, iwi: String, hapu: String, search: String) {
        // (name: String, x: Double, y: Double, location: String, iwi: String)
        val arai = Marae("Arai Te Uru", -45.83955732551009, 170.4870606057339, "Te Paihere", "UniqueIwi" )
        val xy = LatLng(arai.x, arai.y)


        // Add a marker in Sydney and move the camera
            //val Arai_Te_Uru = LatLng(-45.83955732551009, 170.4870606057339)

        val i = 0
//        for (marae in maraeData) {
//            mMap.addMarker(MarkerOptions().position(marae.position).title(marae.name))
//        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(xy))
    }
}