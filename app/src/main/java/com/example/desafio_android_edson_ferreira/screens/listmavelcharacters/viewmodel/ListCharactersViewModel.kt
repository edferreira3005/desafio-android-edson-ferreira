package com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.meuprojetomarvel.marvelcharacters.model.Characters
import br.com.meuprojetomarvel.marvelcharacters.model.DadosJson
import com.example.desafio_android_edson_ferreira.api.MarvelCharactersService
import com.example.desafio_android_edson_ferreira.api.di.DaggerApiComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListCharactersViewModel : ViewModel() {
    var characters: MutableLiveData<List<Characters>> = MutableLiveData()
    var charactersLoadError = MutableLiveData<Boolean>()
    var loading = MutableLiveData<Boolean>()

    @Inject
    lateinit var charactersService: MarvelCharactersService

    private val disposable = CompositeDisposable()

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun refresh() {
        fetchMarvelCharacters()
    }

    private fun fetchMarvelCharacters() {
        loading.value = true
        disposable.add(
            charactersService.getChatacters()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<DadosJson>() {
                    override fun onSuccess(dados: DadosJson) {
                        characters.value = dados.dataCharacters!!.result
                        charactersLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        charactersLoadError.value = true
                        loading.value = false
                        Log.e("erro", e.toString())
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}