package com.example.maps.com.example.maps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maps.MaraeCollection
import com.example.maps.R

/**
 * Custom RecyclerView Adapter class that helps display Marae wiki entries to a user
 *
 * @author Hugo Phibbs
 */
class WikiAdapter(private val maraeCollection: MaraeCollection) :
    RecyclerView.Adapter<WikiAdapter.MaraeWikiEntryVH>() {

    /**
     * Custom ViewHolder class to display Marae info in the wiki view
     *
     * @param view View that this ViewHolder holds
     */
    class MaraeWikiEntryVH(view: View) : RecyclerView.ViewHolder(view) {
        val descriptionTV : TextView;

        init {
            descriptionTV = view.findViewById(R.id.marae_description_tv);
            addListener()
        }

        /**
         * Adds an on click listener to the view that this ViewHolder has
         */
        private fun addListener()  {
            descriptionTV.setOnClickListener {
                // TODO: Open a new marae info screen
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MaraeWikiEntryVH {
        // What does attach to root actually do?
        val maraeEntryView = LayoutInflater.from(parent.context).inflate(R.layout.marae_wiki_entry, parent, false)
        return MaraeWikiEntryVH(maraeEntryView);
    }

    override fun onBindViewHolder(holder: MaraeWikiEntryVH, position: Int) {
        holder.descriptionTV.text = maraeCollection.getMaraeAtIndex(position).toString()
    }

    override fun getItemCount(): Int {
        return maraeCollection.size();
    }
}