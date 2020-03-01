package com.example.desafio_android_edson_ferreira.api.di

import com.example.desafio_android_edson_ferreira.api.MarvelCharactersService
import com.example.desafio_android_edson_ferreira.screens.characterhq.viewmodel.CharacterHQViewModel
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.viewmodel.ListCharactersViewModel
import dagger.Component
import org.jetbrains.annotations.NotNull

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: MarvelCharactersService)
    fun inject(viewmodel : ListCharactersViewModel)
    fun inject(viewmodel : CharacterHQViewModel)
}