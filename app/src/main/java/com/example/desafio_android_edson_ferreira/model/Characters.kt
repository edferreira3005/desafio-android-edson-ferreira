package com.example.desafio_android_edson_ferreira.model

import com.google.gson.annotations.SerializedName
import java.io.File
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

    fun getPath() : String = thumb!!.path + File.separator + thumb!!.file_uncanny + "." + thumb!!.extension
}