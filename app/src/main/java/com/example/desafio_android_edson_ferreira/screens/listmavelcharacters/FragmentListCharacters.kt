package com.example.desafio_android_edson_ferreira.screens.listmavelcharacters

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter.ListCharactersAdapter
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter.Pagination
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.viewmodel.ListCharactersViewModel
import com.example.desafio_android_edson_ferreira.utils.Constants
import kotlinx.android.synthetic.main.fragment_list_characters.*
import java.util.*


class FragmentListCharacters : Fragment() {

    private lateinit var viewModel: ListCharactersViewModel
    private val adapter: ListCharactersAdapter = ListCharactersAdapter(ArrayList())
    private var offset: Int = 0
    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersList.layoutManager = LinearLayoutManager(activity)
        charactersList.adapter = adapter

        viewModel = ViewModelProviders.of(this).get<ListCharactersViewModel>(ListCharactersViewModel::class.java)
        viewModel.refresh(0)

            charactersList.addOnScrollListener(object : Pagination((charactersList!!.layoutManager as LinearLayoutManager?)!!) {
                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun carregarMaisItens() {
                    isLoading = true
                    viewModel.refresh(offset.plus(Constants.LIMITE))
                }
            })

        observeFields()
    }

    private fun observeFields(){
        viewModel.characters.observe(this, androidx.lifecycle.Observer { listCharacters ->
            if (charactersList != null) {
                charactersList.visibility = View.VISIBLE
                adapter.updateCountries(listCharacters)

                isLoading = false
                isLastPage = false
            }
        })

        viewModel.charactersLoadError.observe(this, androidx.lifecycle.Observer { isError ->
            if(isError != null)
                list_error.visibility = if(isError) View.VISIBLE else View.GONE
        })

        viewModel.loading.observe(this, androidx.lifecycle.Observer { isLoading ->
            if (loading != null)
                loading.visibility = if (isLoading) View.VISIBLE else View.GONE

            if (isLoading) {
                list_error.visibility = View.GONE
            }
        })
    }
}
