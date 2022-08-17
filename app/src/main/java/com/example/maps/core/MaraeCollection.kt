package com.example.maps.core


import com.example.maps.core.Marae


/**
* Class to hold a collection of Marae
 *
 * @author Hugo Phibbs
 * @since 6/8/22
 */
class MaraeCollection constructor(private val maraeArr: Array<Marae>) {

    init {

    }

    /**
     * Allows a user to search Marae that this MaraeCollection has, according to a keyword
     *
     * Does not change the state of this MaraeCollection, instead returns another MaraeCollection.
     * This is so the friendly methods of this class can be used for another collection of Marae
     *
     * @param searchString String for a string query entered by a user
     * @return a new MaraeCollection with contained Marae
     */
    /*fun searchMarae(searchString: String): MaraeCollection {
        // TODO normalize maori vowels, perhaps it's own function?
        val result : ArrayList<Marae> = ArrayList();
        for (marae in maraeArr) {
            for (keyWord in marae.keyWords()) {
                if (keyWord.lowercase().contains(searchString.lowercase())) {
                    result.add(marae)
                }
            }
        }
        return MaraeCollection(result.toTypedArray());
    }*/

    /**
     * Returns all the Marae in this MaraeCollection
     *
     * @return Array of Marae as described
     */
    fun getMarae(): Array<Marae> {
        return maraeArr;
    }

    /**
     * Returns the Marae at a given index in this MaraeCollection
     *
     * Intended to be used on wiki page, when a user selects a marae from a list, best way to find the marae selected is to just go by index
     *
     * May seem overkill, but what the hell
     *
     * @param index Integer as described
     * @return Marae as described
     */
    fun getMaraeAtIndex(index : Int): Marae {
        return maraeArr[index]
    }

    fun size() : Int {
        return maraeArr.size;
    }

    // TODO: a method for getting a description of all relevant marae?
}