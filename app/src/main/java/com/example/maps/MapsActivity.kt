package com.example.maps

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.maps.core.Marae
import com.example.maps.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener,GoogleMap.InfoWindowAdapter {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var maraeCollection: Array<Marae>

    private var myContentsView: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myContentsView = layoutInflater.inflate(R.layout.popup, null);

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
        mMap.setInfoWindowAdapter(this)



        val bufferedReader = InputStreamReader(assets.open("Marae.json")).buffered()
        maraeCollection = getMaraeCollection(bufferedReader)

        // Create a Marker array and iterate through marae to add them to the map
        var mMarkers: java.util.ArrayList<Marker> = java.util.ArrayList()

        for (marae in maraeCollection) {
            val LL = LatLng(marae.Y, marae.X)
            val marker: Marker = mMap.addMarker(MarkerOptions().position(LL).title(marae.Name))
            marker.tag = marae
            mMarkers.add(marker)
        }
    }

    fun getMaraeCollection(bufferedReader : BufferedReader): Array<Marae> {

        // lateinit var jsonString: String
        val jsonString = bufferedReader.use(BufferedReader::readText)

        val arrayMaraeType = object : TypeToken<Array<Marae>>() {}.type
        return Gson().fromJson(jsonString, arrayMaraeType)
    }

    override fun onMarkerClick(p0: Marker): Boolean {

        TODO("Not yet implemented")
    }

    override fun getInfoWindow(p0: Marker): View? {
        return null
    }

    override fun getInfoContents(p0: Marker): View? {
        val ma: Marae = p0.tag as Marae
        val iwi = myContentsView?.findViewById<TextView>(com.example.maps.R.id.iwi)
        val title = myContentsView?.findViewById<TextView>(com.example.maps.R.id.title)
        val region = myContentsView?.findViewById<TextView>(com.example.maps.R.id.region)
        val location = myContentsView?.findViewById<TextView>(com.example.maps.R.id.location)
        if (iwi != null) {
            if (ma.Iwi == ""){
                iwi.text = "Iwi information not available"
            } else {
                iwi.text = "Iwi: " + ma.Iwi
            }
        }
        if (title != null) {
            title.text = ma.Name
        }
        if (region != null) {
            region.text = "Region: " + ma.TPK_Region
        }
        if (location != null) {
            location.text = "Address: " + ma.Location
        }
        return myContentsView

    }
}