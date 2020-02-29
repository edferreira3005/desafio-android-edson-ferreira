package com.example.desafio_android_edson_ferreira.screens.listmavelcharacters.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio_android_edson_ferreira.R

class ListCharactersAdapter :
    RecyclerView.Adapter<ListCharactersAdapter.ListCharactersViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListCharactersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return ListCharactersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListCharactersViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    class ListCharactersViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
    }
}