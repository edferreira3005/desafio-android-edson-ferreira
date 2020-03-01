package br.com.meuprojetomarvel.marvelcharacters.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class DadosJson : Serializable {
    @SerializedName("status")
    var status : String = "ERRO"
    @SerializedName("data")
    var dataCharacters: DataCharacters? = null
}