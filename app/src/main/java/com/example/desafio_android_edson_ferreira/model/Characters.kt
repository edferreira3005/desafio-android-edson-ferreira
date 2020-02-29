package br.com.meuprojetomarvel.marvelcharacters.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Characters : Serializable {

    @SerializedName("id")
    var id : Int? = null
    @SerializedName("name")
    var nome : String? = null
    @SerializedName("description")
    var description : String? = null
    @SerializedName("modified")
    var modified : String? = null

    @SerializedName("thumbnail")
    var thumb : Thumbnail? = null

    var modifiedFormated : String? = null
    var bitmap : ByteArray? = null
}