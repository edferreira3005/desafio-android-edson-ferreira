package com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android_edson_ferreira.model.Characters
import com.example.desafio_android_edson_ferreira.R
import com.example.desafio_android_edson_ferreira.utils.Util
import kotlinx.android.synthetic.main.item_character.view.*

class ListCharactersAdapter
    constructor(private var listCharacters: ArrayList<Characters>):
    RecyclerView.Adapter<ListCharactersAdapter.ListCharactersViewHolder>() {

    fun updateCountries(newListCharacters: ArrayList<Characters>) {
        listCharacters.clear()
        listCharacters.addAll(newListCharacters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCharactersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ListCharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListCharactersViewHolder, position: Int) {
        holder.bind(listCharacters[position])
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    class ListCharactersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bind(character: Characters) {
            itemView.imgCharacter
            itemView.tvName.text = character.nome
            Util.loadImage(
                itemView.imgCharacter, character.getPath().replace("http","https"),
                Util.getProgressDrawable(itemView.imgCharacter.context)
            )

            itemView.lnCharacter.setOnClickListener {
                val onClick = itemView.context as OnClickCharacter
                onClick.onClick(character)
            }
        }
    }

    interface OnClickCharacter{
        fun onClick(character: Characters)
    }
}