package com.example.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maps.com.example.maps.WikiAdapter
import com.example.maps.core.Marae
import com.example.maps.core.MaraeCollection

// TODO how are we going to through around the MaraeCollection?

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class WikiFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView;
    private lateinit var searchView: SearchView;

    private lateinit var maraeCollection : MaraeCollection;

    private fun initMaraeCollection() {
        //TODO remove later!
        var marae1 = Marae("marae1", 1.toDouble(), 2.toDouble(), "", "")
        var marae2 = Marae("marae2", 1.toDouble(), 2.toDouble(), "", "")
        var marae3 = Marae("marae3", 1.toDouble(), 2.toDouble(), "", "")
        maraeCollection = MaraeCollection(arrayOf(marae1, marae2, marae3))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMaraeCollection()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create the view for this fragment
        val view : View = inflater.inflate(R.layout.fragment_wiki, container, false)

        // Add necessary components to the view

        addComponentsToView(view);
        // Return the created view
        return view;
    }

    fun addComponentsToView(view : View) {
        initRecyclerView(view)
        searchView = view.findViewById(R.id.maraeSearchView);
    }

    /**
     * Initialiazes the RecyclerView for different Marae
     *
     * Binds it to it's adapter etc
     *
     * @param view View object of this fragment
     */
    fun initRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.wikiRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = WikiAdapter(maraeCollection);

    }

    /**
    * Adds a search listener to the search box
    */
    fun addSearchListener() {

    }
}