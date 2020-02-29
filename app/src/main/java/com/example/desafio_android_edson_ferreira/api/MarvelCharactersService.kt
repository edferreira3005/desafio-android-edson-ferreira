package com.example.desafio_android_edson_ferreira.api

import br.com.meuprojetomarvel.marvelcharacters.model.DadosJson
import com.example.desafio_android_edson_ferreira.api.di.DaggerApiComponent
import com.example.desafio_android_edson_ferreira.utils.Constants
import com.example.desafio_android_edson_ferreira.utils.Util
import io.reactivex.Single
import retrofit2.Call
import java.util.HashMap
import javax.inject.Inject

class MarvelCharactersService {
    @Inject
    lateinit var api: MarvelCharactersApi
    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<Call<DadosJson>>{
        return api.getCharacters(request())
    }

    private fun request() : HashMap<String, String> {
        return Util.retornaHashJson(
            "=",
            String.format("ts=%s", Constants.TS),
            String.format("apikey=%s", Constants.PUBLIC_KEY),
            String.format("hash=%s", Constants.HASH)
        )
    }
}