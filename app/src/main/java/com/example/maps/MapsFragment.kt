package com.example.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maps.R
import com.example.maps.core.Marae
import com.example.maps.core.MaraeController
import com.google.android.gms.common.api.GoogleApi
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        googleMap.mapType = googleMap

//            GoogleMapOptions()
//                .mapId(resources.getString(R.string.map_id))



        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

//        val maraeData = Array(10) { Marae() }
//        maraeData[1] = Marae("Marae 1", -45.83955732551009, 175.4870606057339, "Test Location", "Test Iwi")
//        maraeData[2] = Marae("Ahikiwi", -45.83955732551009, 180.4870606057339, "Test Location", "Test Iwi")
//        maraeData[3] = Marae("Akerama", -45.83955732551009, 180.4870606057339, "Test Location", "Test Iwi")

        // Create a Marker array and iterate through marae to add them to the map
        var mMarkers: ArrayList<Marker> = ArrayList()

//        for (marae in MaraeController.maraeCollection) {
//            val LL = LatLng(marae.x, marae.y)
//            mMarkers.add(
//                googleMap.addMarker(MarkerOptions().position(LL).title(marae.name))
//            )
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}