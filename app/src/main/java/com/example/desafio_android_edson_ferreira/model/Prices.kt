package com.example.desafio_android_edson_ferreira.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Prices : Serializable{

    @SerializedName("type")
    var type: String? = null
    @SerializedName("price")
    var price: Double? = null
}