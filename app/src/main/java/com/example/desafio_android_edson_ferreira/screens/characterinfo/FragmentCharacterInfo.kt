package com.example.desafio_android_edson_ferreira.screens.characterinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.model.Characters
import com.example.desafio_android_edson_ferreira.utils.Util
import kotlinx.android.synthetic.main.fragment_character_info.*
import kotlinx.android.synthetic.main.fragment_character_info.imgCharacter

class FragmentCharacterInfo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_character_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var character: Characters? = null
        if(arguments != null)
            character = arguments!!.getSerializable("character") as Characters?

        if(character != null) {
            Util.loadImage(
                imgCharacter, character.getPath().replace("http", "https"),
                Util.getProgressDrawable(imgCharacter.context)
            )
            tvName.text = character.nome
            tvDescription.text = character.description
        }
    }
}