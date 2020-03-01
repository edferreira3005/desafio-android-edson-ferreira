package com.example.desafio_android_edson_ferreira.api

import android.util.Log
import com.example.desafio_android_edson_ferreira.model.DadosJson
import com.example.desafio_android_edson_ferreira.api.di.DaggerApiComponent
import com.example.desafio_android_edson_ferreira.utils.Constants
import com.example.desafio_android_edson_ferreira.utils.Util
import io.reactivex.Single
import java.util.HashMap
import javax.inject.Inject

class MarvelCharactersService {
    @Inject
    lateinit var api: MarvelCharactersApi
    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getChatacters(offset : Int): Single<DadosJson>{
        return api.getCharacters(request(offset))
    }

    fun getComics(id : Int): Single<DadosJson>{
        return api.getComics(id,request(Constants.LIMITE))
    }

    private fun request(offset : Int) : HashMap<String, String> {
        Log.e("offset",offset.toString())
        return Util.retornaHashJson(
            "=",
            String.format("ts=%s", Constants.TS),
            String.format("apikey=%s", Constants.PUBLIC_KEY),
            String.format("hash=%s", Constants.HASH),
            String.format("limit=%s", Constants.LIMITE.toString()),
            String.format("offset=%s", offset.toString())
        )
    }
}