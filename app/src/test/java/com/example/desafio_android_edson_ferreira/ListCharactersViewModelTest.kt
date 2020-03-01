package com.example.desafio_android_edson_ferreira

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.desafio_android_edson_ferreira.model.Characters
import br.com.meuprojetomarvel.marvelcharacters.model.DadosJson
import br.com.meuprojetomarvel.marvelcharacters.model.DataCharacters
import com.example.desafio_android_edson_ferreira.api.MarvelCharactersService
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.viewmodel.ListCharactersViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.internal.schedulers.ExecutorScheduler.ExecutorWorker
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Callable
import java.util.concurrent.Executor

class ListCharactersViewModelTest {
    @Rule @JvmField
    public var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var charactersService: MarvelCharactersService

    @InjectMocks
    var listCharactersViewModel: ListCharactersViewModel = ListCharactersViewModel()
    private lateinit var testSingle: Single<DadosJson>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getCountriesSuccess() {
        val characters = Characters()
        val data = DataCharacters()
        val dados = DadosJson()
        val listCharacters = ArrayList<Characters>()

        listCharacters.add(characters)
        data.result = listCharacters
        dados.dataCharacters = data
        testSingle = Single.just<DadosJson>(dados)

        Mockito.`when`<Any>(charactersService.getChatacters()).thenReturn(testSingle)
        listCharactersViewModel.refresh()

        Assert.assertEquals(1, listCharactersViewModel.characters.value!!.size)
        Assert.assertEquals(false, listCharactersViewModel.charactersLoadError.value)
        Assert.assertEquals(false, listCharactersViewModel.loading.value)
    }

    @Before
    fun setupRxSchedulers() {
        val immediate: Scheduler = object : Scheduler() {
            override fun createWorker(): Worker {
                return ExecutorWorker(
                    Executor { runnable: Runnable -> runnable.run() },
                    true
                )
            }
        }
        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler?>? -> immediate }
    }
}