package br.com.meuprojetomarvel.marvelcharacters.model

import com.example.desafio_android_edson_ferreira.model.Characters
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataCharacters : Serializable {
    @SerializedName("results")
    var result : ArrayList<Characters>? = null
}