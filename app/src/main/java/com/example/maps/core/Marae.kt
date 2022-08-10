package com.example.maps.core

/**
 * Data class for a Marae class
 *
 * @author Lucy Sladden
 */
data class Marae(
    val Alternate: Any,
    val Comments: Any,
    val Feedback: String,
    val GIS_MID: Int,
    /* Link to google maps for this Marae*/
    val GoogleMaps: String,
    val Hapu: String,
    val Iwi: String,
    /* Location of this Marae, ie address*/
    val Location: String,
    val Name: String,
    val Search: String,
    val Source: String,
    val TKM_MID: Int,
    val TPK_Region: String,
    val Type: String,
    val Wharenui: String,
    /** X coordinate of this Marae */
    val X: Double,
    /** Y coordinate of this Marae */
    val Y: Double
)