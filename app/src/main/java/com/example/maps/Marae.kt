package com.example.maps

import com.google.android.gms.maps.model.LatLng

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
    }
