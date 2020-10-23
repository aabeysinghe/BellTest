package com.example.fragmentcommunicate.Pojo

import com.google.gson.annotations.SerializedName

data class Images(
    val poster: List<String>,
   /* @SerializedName("pr-tser")
    val prtser: List<String>,
    @SerializedName("pr-tser-sm")
    val prtsersm: List<String>,*/
    val square: List<String>,
    val thumbnail: List<String>
)