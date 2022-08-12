package com.example.maps

import android.content.Context
import androidx.fragment.app.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Environment

import android.os.Bundle
import android.system.Os.open
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    val jsonString123 = "[{\"GIS_MID\":2,\"Name\":\"Ahikiwi\",\"Alternate\":\"\",\"Wharenui\":\"Te Aranga Mai o te Whakapono\",\"Type\":\"Tribal\",\"X\":173.728838,\"Y\":-35.791132,\"Location\":\"202 Ahikiwi Rd., Maropiu, SH12, Kaihu Valley\",\"Iwi\":\"Ngāti Whātua\",\"Hapu\":\"Ngāti Hinga\",\"Comments\":\"\",\"Source\":\"F/S, TKM\",\"TPK_Region\":\"Te Taitokerau\",\"TKM_MID\":6018,\"Search\":\"Ahikiwi | Te Aranga Mai o te Whakapono | Ngati Whatua | Ngati Hinga | 202 Ahikiwi Rd., Maropiu, SH12, Kaihu Valley | Te Taitokerau\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Ahikiwi - GIS_MID=2\\\">Send feedback on Ahikiwi</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-35.7911320000000,173.7288380000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":3,\"Name\":\"Akerama\",\"Alternate\":\"\",\"Wharenui\":\"Huiarau / Ruapekapeka\",\"Type\":\"Tribal\",\"X\":174.166267046,\"Y\":-35.4864463618,\"Location\":\"19 Haile Rd., Towai\",\"Iwi\":\"Ngāpuhi\",\"Hapu\":\"Ngāti Hau\",\"Comments\":\"\",\"Source\":\"F/S, TKM\",\"TPK_Region\":\"Te Taitokerau\",\"TKM_MID\":6218,\"Search\":\"Akerama | Huiarau / Ruapekapeka | Ngapuhi | Ngati Hau | 19 Haile Rd., Towai | Te Taitokerau\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Akerama - GIS_MID=3\\\">Send feedback on Akerama</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-35.4864463617866,174.1662670460786/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":696,\"Name\":\"Akura\",\"Alternate\":\"\",\"Wharenui\":\"No wharenui\",\"Type\":\"Tribal\",\"X\":175.643918,\"Y\":-40.931216,\"Location\":\"142 Akura Rd., Masterton\",\"Iwi\":\"Ngāti Kahungunu, Rangitāne\",\"Hapu\":\"Ngāti Mātangiuru, Ngāti Te Ahuahu, Ngāti Te Hina\",\"Comments\":\"kahungunu.iwi.nz\",\"Source\":\"TKM, WWW\",\"TPK_Region\":\"Ikaroa-Rāwhiti\",\"TKM_MID\":4922,\"Search\":\"Akura | No wharenui | Ngati Kahungunu, Rangitane | Ngati Matangiuru, Ngati Te Ahuahu, Ngati Te Hina | 142 Akura Rd., Masterton | Ikaroa-Rawhiti\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Akura - GIS_MID=696\\\">Send feedback on Akura</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-40.9312160000000,175.6439180000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":988,\"Name\":\"Alfriston College\",\"Alternate\":\"\",\"Wharenui\":\"\",\"Type\":\"Institutional\",\"X\":174.91818,\"Y\":-37.018743,\"Location\":\"550 Porchester Rd., Randwick Park, Manurewa\",\"Iwi\":\"\",\"Hapu\":\"\",\"Comments\":\"\",\"Source\":\"Pat Park, TKM\",\"TPK_Region\":\"Tāmaki Makaurau\",\"TKM_MID\":6315,\"Search\":\"Alfriston College | 550 Porchester Rd., Randwick Park, Manurewa | Tamaki Makaurau\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Alfriston College - GIS_MID=988\\\">Send feedback on Alfriston College</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-37.0187430000000,174.9181800000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":5,\"Name\":\"Aorangi\",\"Alternate\":\"\",\"Wharenui\":\"Maniaihu\",\"Type\":\"Tribal\",\"X\":175.58668,\"Y\":-40.246045,\"Location\":\"6 Waughs Rd. (Near Aorangi Rd.), Fielding\",\"Iwi\":\"Ngāti Raukawa ki te Tonga\",\"Hapu\":\"Ngāti Kauwhata\",\"Comments\":\"\",\"Source\":\"F/S, TKM\",\"TPK_Region\":\"Te Tai Hauāuru\",\"TKM_MID\":5005,\"Search\":\"Aorangi | Maniaihu | Ngati Raukawa ki te Tonga | Ngati Kauwhata | 6 Waughs Rd. (Near Aorangi Rd.), Fielding | Te Tai Hauauru\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Aorangi - GIS_MID=5\\\">Send feedback on Aorangi</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-40.2460450000000,175.5866800000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":6,\"Name\":\"Aotearoa\",\"Alternate\":\"\",\"Wharenui\":\"Hoturoa / Rangikawa\",\"Type\":\"Tribal\",\"X\":175.580349,\"Y\":-38.191005,\"Location\":\"404 Aotearoa Rd., Wharepapa South\",\"Iwi\":\"Raukawa, Waikato\",\"Hapu\":\"Ngāti Korokī, Ngāti Raukawa ki Panehākua, Ngāti Takihiku\",\"Comments\":\"whakapapa.maori.org.nz, Otorohanga DC\",\"Source\":\"F/S, MFish, TKM, WWW\",\"TPK_Region\":\"Waikato-Waiariki\",\"TKM_MID\":5115,\"Search\":\"Aotearoa | Hoturoa / Rangikawa | Raukawa, Waikato | Ngati Koroki, Ngati Raukawa ki Panehakua, Ngati Takihiku | 404 Aotearoa Rd., Wharepapa South | Waikato-Waiariki\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Aotearoa - GIS_MID=6\\\">Send feedback on Aotearoa</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-38.1910050000000,175.5803490000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":7,\"Name\":\"Aotearoa\",\"Alternate\":\"\",\"Wharenui\":\"Ngākaunui\",\"Type\":\"Tribal\",\"X\":174.223121,\"Y\":-39.51654,\"Location\":\"63 Hastings Rd., Ōkaiawa\",\"Iwi\":\"Ngāruahine\",\"Hapu\":\"Ōkahu - Inuāwai\",\"Comments\":\"whakapapa.maori.org.nz, Taranaki Regional Council\",\"Source\":\"F/S, MFish, TKM, WWW\",\"TPK_Region\":\"Te Tai Hauāuru\",\"TKM_MID\":4940,\"Search\":\"Aotearoa | Ngakaunui | Ngaruahine | Okahu - Inuawai | 63 Hastings Rd., Okaiawa | Te Tai Hauauru\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Aotearoa - GIS_MID=7\\\">Send feedback on Aotearoa</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-39.5165400000000,174.2231210000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"},{\"GIS_MID\":1033,\"Name\":\"Aotearoa Institute\",\"Alternate\":\"\",\"Wharenui\":\"Taiwere\",\"Type\":\"Institutional\",\"X\":176.234949,\"Y\":-38.127411,\"Location\":\"Te Wananga o Aotearoa, Te Kuratini o Nga Waka, 1 Dinsdale St., Rotorua\",\"Iwi\":\"\",\"Hapu\":\"\",\"Comments\":\"\",\"Source\":\"Pat Park, TKM\",\"TPK_Region\":\"Waikato-Waiariki\",\"TKM_MID\":6353,\"Search\":\"Aotearoa Institute | Taiwere | Te Wananga o Aotearoa, Te Kuratini o Nga Waka, 1 Dinsdale St., Rotorua | Waikato-Waiariki\",\"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Aotearoa Institute - GIS_MID=1033\\\">Send feedback on Aotearoa Institute</a>\",\"GoogleMaps\":\"<a href=\\\"https://www.google.com/maps/place/-38.1274110000000,176.2349490000000/data=!3m1!1e3\\\">View location on Google Maps</a>\"}"

    // val maraeCollection = context?.assets?.open("Marae.json")?.let { getMaraeCollection(it.bufferedReader()) }

    // val maraeCollection = getActivity()?.let { getMaraeCollection(it.applicationContext) }

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