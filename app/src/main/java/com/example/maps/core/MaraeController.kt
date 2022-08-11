package com.example.maps.core

/**
 * Class for manipulating and formatting Marae
 *
 * Meant to accompany Marae data class.
 *
 * @author Hugo Phibbs
 */
class MaraeController {

    /**
     * Returns a String representation of an inputted Marae
     *
     * @param marae Marae object to find a string representation for
     */
    fun maraeToString(marae : Marae): String {
        return "Marae object with name: ${marae.Name}, belonging to ${marae.Iwi}, located in ${marae.Location}"
    }

    /**
     * Function to return the keywords of a Marae
     *
     * Intended to be used for searching a list of marae
     *
     * @param marae Marae to find the keywords for
     * @return array of Strings as described
     */
    fun keyWords(marae : Marae) : Array<String>{
        // TODO update for hapu, wharenui etc?
        return arrayOf(marae.Name, marae.Iwi, marae.Location)
    }
}