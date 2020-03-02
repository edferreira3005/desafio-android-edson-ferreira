package com.example.desafio_android_edson_ferreira.utils.exception

import android.content.Context
import android.widget.Toast
import java.lang.Exception

class MarvelApiException(var exception: Throwable, var context: Context) : Exception(exception) {

    fun showError(){
            Toast.makeText(context,exception.message, Toast.LENGTH_LONG).show()
    }
}