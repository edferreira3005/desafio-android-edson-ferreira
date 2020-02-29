package br.com.meuprojetomarvel.marvelcharacters.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DataCharacters : Serializable {

    @SerializedName("results")
    var result : ArrayList<Characters>? = null
}