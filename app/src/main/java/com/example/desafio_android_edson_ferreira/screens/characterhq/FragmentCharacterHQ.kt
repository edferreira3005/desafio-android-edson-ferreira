package com.example.desafio_android_edson_ferreira.screens.characterhq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.screens.characterhq.viewmodel.CharacterHQViewModel
import com.example.desafio_android_edson_ferreira.utils.Util
import kotlinx.android.synthetic.main.fragment_character_hq.*

class FragmentCharacterHQ : Fragment() {
    private lateinit var viewModel: CharacterHQViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_hq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val id = arguments!!.getInt("id")

            viewModel = ViewModelProviders.of(this)
                .get<CharacterHQViewModel>(CharacterHQViewModel::class.java)
            viewModel.setIdCharacter(id)
            viewModel.refresh()
        }

        observeFields()
    }

    private fun observeFields() {
        viewModel.characters.observe(this, androidx.lifecycle.Observer { listCharacters ->
            val character = viewModel.getMostExpensiveComic(listCharacters)

            if(character != null) {
                lnComic.visibility = View.VISIBLE
                Util.loadImage(
                    imgComic, character.getPath().replace("http", "https"),
                    Util.getProgressDrawable(imgComic.context)
                )

                tvTitulo.text = character.nome
                tvDescription.text = character.description

                if(character.lista_preco != null){
                    if(character.lista_preco!!.isNotEmpty())
                        tvPrice.text = character.lista_preco!![0].price.toString()
                }
            }
        })

        viewModel.charactersLoadError.observe(this, androidx.lifecycle.Observer { isError ->
            if(isError != null)
                error.visibility = if(isError) View.VISIBLE else View.GONE
        })

        viewModel.loading.observe(this, androidx.lifecycle.Observer { isLoading ->
            if (loading != null)
                loading.visibility = if (isLoading) View.VISIBLE else View.GONE

            if (isLoading) {
                lnComic.visibility = View.GONE
                error.visibility = View.GONE
            }
        })
    }
}