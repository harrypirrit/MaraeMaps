package com.example.maps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.maps.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MaraeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MaraeFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marae, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MaraeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaraeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}