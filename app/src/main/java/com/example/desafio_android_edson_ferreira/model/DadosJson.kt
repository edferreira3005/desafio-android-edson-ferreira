package com.example.desafio_android_edson_ferreira.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DadosJson : Serializable {
    @SerializedName("status")
    var status : String = "ERRO"
    @SerializedName("data")
    var dataCharacters: DataCharacters? = null
}