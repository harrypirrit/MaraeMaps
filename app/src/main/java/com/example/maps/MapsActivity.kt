package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import com.example.maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.InputStreamReader

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
        val arai = Marae("Arai Te Uru", -45.83955732551009, 170.4870606057339, "Te Paihere", "UniqueIwi" )

        // Add a marker in Sydney and move the camera
        val Arai_Te_Uru = LatLng(-45.83955732551009, 170.4870606057339)
        mMap.addMarker(MarkerOptions().position(arai.position).title(arai.name))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arai.position))

        var bufferedReader = InputStreamReader(assets.open("Marae.csv")).buffered()
        var maraeData = getMaraeData(bufferedReader)

        // Make thread wait a second for data to be loaded
        //android.os.SystemClock.sleep(1000)

//        for (marae in maraeData) {ow t
//            mMap.addMarker(MarkerOptions().position(marae.position).title(marae.name))
//        }



    }
}