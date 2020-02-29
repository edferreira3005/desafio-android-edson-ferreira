package com.example.desafio_android_edson_ferreira.api.di

import com.example.desafio_android_edson_ferreira.api.MarvelCharactersService
import dagger.Component
import org.jetbrains.annotations.NotNull

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: MarvelCharactersService)
}