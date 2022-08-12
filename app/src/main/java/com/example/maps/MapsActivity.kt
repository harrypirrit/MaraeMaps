package com.example.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import com.example.maps.core.Marae
import com.example.maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
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

        // Add a marker in Sydney and move the camera

        // Add a marker in Sydney and move the camera
        val arai = LatLng(-45.83955732551009, 170.4870606057339)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(arai))



        val bufferedReader = InputStreamReader(assets.open("Marae.json")).buffered()
        val  maraeCollection = getMaraeCollection(bufferedReader)

        // Create a Marker array and iterate through marae to add them to the map
        var mMarkers: java.util.ArrayList<Marker> = java.util.ArrayList()

        for (marae in maraeCollection) {
            val LL = LatLng(marae.Y, marae.X)
            mMarkers.add(
                mMap.addMarker(MarkerOptions().position(LL).title(marae.Name))
            )
        }
    }

    fun getMaraeCollection(bufferedReader : BufferedReader): Array<Marae> {

        // lateinit var jsonString: String
        val jsonString = bufferedReader.use(BufferedReader::readText)

        val arrayMaraeType = object : TypeToken<Array<Marae>>() {}.type
        return Gson().fromJson(jsonString, arrayMaraeType)
    }
}