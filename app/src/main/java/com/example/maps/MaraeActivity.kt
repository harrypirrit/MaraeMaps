package com.example.maps

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.maps.core.Marae
import com.google.gson.Gson


class MaraeActivity : AppCompatActivity() {

    private var param1: String? = "{\n" +
            "   \"GIS_MID\":1,\n" +
            "   \"Name\":\"Ko Te Ahua\",\n" +
            "   \"Alternate\":null,\n" +
            "   \"Wharenui\":\"Ko Te Ahua\",\n" +
            "   \"Type\":\"Tribal\",\n" +
            "   \"X\":173.432446,\n" +
            "   \"Y\":-35.061892,\n" +
            "   \"Location\":\"652 Parapara-Toatoa Road, Toatoa\",\n" +
            "   \"Iwi\":\"Ngāti Kahu\",\n" +
            "   \"Hapu\":\"Ngāti Te Rūrunga \\/ Te Paatu\",\n" +
            "   \"Comments\":null,\n" +
            "   \"Source\":\"TKM\",\n" +
            "   \"TPK_Region\":\"Te Taitokerau\",\n" +
            "   \"TKM_MID\":4597,\n" +
            "   \"Search\":\"Ko Te Ahua | Ko Te Ahua | Ngati Kahu | Ngati Te Rurunga \\/ Te Paatu | 652 Parapara-Toatoa Road, Toatoa | Te Taitokerau\",\n" +
            "   \"Feedback\":\"<a href=\\\"mailto:tpkmaps@tpk.govt.nz?subject=Feedback on Ko Te Ahua - GIS_MID=1\\\">Send feedback on Ko Te Ahua<\\/a>\",\n" +
            "   \"GoogleMaps\":\"<a href=\\\"https:\\/\\/www.google.com\\/maps\\/place\\/-35.0618920000000,173.4324460000000\\/data=!3m1!1e3\\\">View location on Google Maps<\\/a>\"\n" +
            "}"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marae)

        val title = findViewById<TextView>(R.id.textViewName)
        val iwi = findViewById<TextView>(R.id.textViewIwi)
        val location = findViewById<TextView>(R.id.textViewLocation)
        val region = findViewById<TextView>(R.id.textViewRegion)

        val gson = Gson()
        val maraeModel = gson.fromJson(param1, Marae::class.java)


        title.text = maraeModel.Name
        iwi.text = maraeModel.Iwi
        location.text = maraeModel.Location
        region.text = maraeModel.TPK_Region

    }
}