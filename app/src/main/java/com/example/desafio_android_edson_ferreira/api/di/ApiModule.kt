package com.example.desafio_android_edson_ferreira.api.di

import com.example.desafio_android_edson_ferreira.api.MarvelCharactersApi
import com.example.desafio_android_edson_ferreira.api.MarvelCharactersService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    val BASE_URL = "https://gateway.marvel.com"

    @Provides
    fun provideCharactersApi(): MarvelCharactersApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create<MarvelCharactersApi>(MarvelCharactersApi::class.java)
    }

    @Provides
    fun getService(): MarvelCharactersService {
        return MarvelCharactersService()
    }
}