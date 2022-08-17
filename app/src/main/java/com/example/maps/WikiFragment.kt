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
// TODO how are we going to through around the MaraeCollection?

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 *
 * @author Hugo Phibbs
 * @param maraeList list of all Marae that can be shown on this fragment
 */
class WikiFragment(private var maraeList: ArrayList<Marae>) : Fragment() {

    /**
     * RecyclerView for showing Marae to a user
     */
    private lateinit var recyclerView: RecyclerView;

    /**
     * Search view for searching marae from the RecyclerView
     */
    private lateinit var maraeSearchView: SearchView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Create the view for this fragment
        val view: View = inflater.inflate(R.layout.fragment_wiki, container, false)
        // Add necessary components to the view

        addComponentsToView(view);
        // Return the created view
        return view;
    }

    fun addComponentsToView(view: View) {
        initRecyclerView(view)
        maraeSearchView = view.findViewById(R.id.maraeSearchView);
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
        recyclerView.adapter = WikiAdapter(maraeList)
    }

    /**
     * Adds a search listener to the search box
     */
    fun addSearchListener() {
        maraeSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                (recyclerView.adapter as WikiAdapter).filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Does default action
                return false // TODO anymore to add here, look into what this does!
            }

        })
    }
}