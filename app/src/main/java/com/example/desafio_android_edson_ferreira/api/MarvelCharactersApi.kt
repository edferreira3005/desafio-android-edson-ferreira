package com.example.desafio_android_edson_ferreira.api

import com.example.desafio_android_edson_ferreira.model.DadosJson
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import java.util.HashMap

interface MarvelCharactersApi {
    @GET("/v1/public/characters")
    fun getCharacters(@QueryMap data: HashMap<String, String>): Single<DadosJson>

    @GET("/v1/public/characters/{id}/comics")
    fun getComics(@Path("id") idCharactere : Int, @QueryMap data: HashMap<String, String>): Single<DadosJson>
}