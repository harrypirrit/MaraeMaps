package com.example.maps

import com.google.android.gms.maps.model.LatLng
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.BufferedReader

class Marae (_name: String, _x: Double, _y: Double, _location: String, _iwi: String) {
    //implement below as complete constructor
        // class Marae (_name: String, _wharenui: String, _x: Double, _y: Double, _location: String, _iwi: String, _hapu: String, _search: String) {

    var name: String
    // var wharenui: String
    var x: Double
    var y: Double
    var position: LatLng
    var location: String
    var iwi: String
    // var hapu: String
    // var search: String

    init {
        this.name = _name
        //this.wharenui = _wharenui
        this.x = _x
        this.y = _y
        this.position = LatLng(x, y)
        this.location = _location
        this.iwi = _iwi
        //this.hapu = _hapu
        //this.search = _search

        println("new Marae object : $name")
    }

    constructor() : this("default", 0.0, 0.0, "default_location", "default_iwi")



    }

    // create getMaraeData method
            // needs to be fed Paths.get("/mapdata/Marae.csv"));
    fun getMaraeData(bufferedReader: BufferedReader): Array<Marae> {
        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)

        val maraeData = Array(1060) { Marae() }
        var i = 0

        // iterate through CSV file
        for (csvRecord in csvParser) {
            println(csvRecord)

//            val name = csvRecord.get(1)
//            val x = csvRecord.get(5)
//            val y = csvRecord.get(6)
//            val location = csvRecord.get(7)
//            val iwi = csvRecord.get(8)

            i = i +1
            // update maraeData at i
//            maraeData[i].name = name
//            maraeData[i].x = x
//            maraeData[i].y = y
//            maraeData[i].location = location

        }

        return maraeData

    }




