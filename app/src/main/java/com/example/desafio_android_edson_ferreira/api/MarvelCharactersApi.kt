package com.example.desafio_android_edson_ferreira.api

import br.com.meuprojetomarvel.marvelcharacters.model.DadosJson
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap
import java.util.HashMap

interface MarvelCharactersApi {
    @GET("/v1/public/characters")
    fun getCharacters(@QueryMap data: HashMap<String, String>): Single<Call<DadosJson>>
}