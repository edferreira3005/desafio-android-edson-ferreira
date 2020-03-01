package com.example.desafio_android_edson_ferreira.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Thumbnail : Serializable {

    var idCharacters : Int? = null

    @SerializedName("path")
    var path : String? = null
    @SerializedName("extension")
    var extension : String? = null

    var file_uncanny : String = "portrait_uncanny"
    var file_landscape : String = "landscape_incredible"
}