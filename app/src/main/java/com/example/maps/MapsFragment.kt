package com.example.maps

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Environment

import android.os.Bundle
import android.system.Os.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.maps.R
import com.example.maps.core.Marae
import com.example.maps.core.MaraeController

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
import java.nio.channels.AsynchronousFileChannel.open

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

        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        var mMarkers: ArrayList<Marker> = ArrayList()

        var activity: FragmentActivity? = this.activity

//        var maraeCollection = this.activity

//        if (maraeCollection != null) {
//            for (marae in maraeCollection) {
//                val LL = LatLng(marae.X, marae.Y)
//                mMarkers.add(
//                    googleMap.addMarker(MarkerOptions().position(LL).title(marae.Name))
//                )
//            }
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



    // put this when you call getMaraeCollection
    // jsonString = context.assets.open("Marae.json").bufferedReader()

    fun getMaraeCollection(bufferedReader : BufferedReader): Array<Marae> {

        lateinit var jsonString: String

        val arrayMaraeType = object : TypeToken<Array<Marae>>() {}.type
        println("output : ${arrayMaraeType}")
        return Gson().fromJson(jsonString, arrayMaraeType)
    }
}