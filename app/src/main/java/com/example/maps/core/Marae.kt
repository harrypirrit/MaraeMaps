package com.example.maps.core

import com.google.android.gms.maps.model.LatLng
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader

/**
 * Class to represent a Marae
 *
 * @param name name of this marae
 * @param x x coordinate of this marae
 * @param y y coordinate of this marae
 * @param location String for the location (region) of this Marae
 * @param iwi String for the iwi that this Marae belongs to
 */
class Marae (var name: String, var x: Double, var y: Double, var location: String, var iwi: String) {
    // TODO implement below as complete constructor
    // class Marae (_name: String, _wharenui: String, _x: Double, _y: Double, _location: String, _iwi: String, _hapu: String, _search: String) {

    // var wharenui: String
    // var hapu: String
    // var search: String TODO what's search?
    var position: LatLng = LatLng(x, y)

    override fun toString(): String {
        return "Marae object with name: ${name}, belonging to ${iwi}, located in ${location}"
    }

    /**
     * Function to return the keywords of this Marae
     *
     * Intended to be used for searching a list of marae
     *
     * @return array of Strings as described
     */
    fun keyWords() : Array<String>{
        // TODO update for hapu, wharenui etc?
        return arrayOf(name, iwi, location)
    }

    constructor() : this("default", 0.0, 0.0, "default_location", "default_iwi")
}

// create getMaraeData method
fun getMaraeData(bufferedReader: BufferedReader): Array<Marae> {

    var csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)

    var maraeData = Array(10) { Marae() }

    // iterate through CSV file
    for ((i, csvRecord) in csvParser.withIndex()) {

        if (i < 10) {
            println("marae[$i]")

            var name = csvRecord.get(1)
            var x = csvRecord.get(5).toDouble()
            var y = csvRecord.get(6).toDouble()
            var position = LatLng(x, y)
            var location = csvRecord.get(7)
            var iwi = csvRecord.get(8)


            // update maraeData at i
            maraeData[i].name = name
            maraeData[i].x = x
            maraeData[i].y = y
            maraeData[i].position = position
            maraeData[i].location = location
            maraeData[i].iwi = iwi
        }
    }

    return maraeData

}
