package com.example.desafio_android_edson_ferreira.screens.listmavelcharacters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter.ListCharactersAdapter
import com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.viewmodel.ListCharactersViewModel
import kotlinx.android.synthetic.main.fragment_list_characters.*
import java.util.*


class FragmentListCharacters : Fragment() {

    val TAG = "listcharacters"
    private lateinit var viewModel: ListCharactersViewModel
    private val adapter: ListCharactersAdapter = ListCharactersAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        charactersList.layoutManager = LinearLayoutManager(activity)
        charactersList.adapter = adapter

        viewModel = ViewModelProviders.of(this).get<ListCharactersViewModel>(ListCharactersViewModel::class.java)
        viewModel.refresh()

        observeFields()
    }

    private fun observeFields(){
        viewModel.characters.observe(this, androidx.lifecycle.Observer { listCharacters ->
            if (charactersList != null) {
                charactersList.visibility = View.VISIBLE
                adapter.updateCountries(listCharacters)
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
                charactersList.visibility = View.GONE
                list_error.visibility = View.GONE
            }
        })
    }
}
