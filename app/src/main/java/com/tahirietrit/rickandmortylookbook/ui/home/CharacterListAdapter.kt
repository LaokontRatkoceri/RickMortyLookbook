package com.tahirietrit.rickandmortylookbook.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.databinding.ItemCharacterListBinding

class CharacterListAdapter(val onItemClick: (Character) -> Unit) :
    RecyclerView.Adapter<CharacterListAdapter.ViewHolder>() {

    var characters: List<Character> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: ItemCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        with(holder.binding) {
            characterName.text = character.name
            characterType.text = character.type
            Picasso.get().load(character.image).into(characterImage)
            root.setOnClickListener {
                onItemClick(character)
            }
        }
    }
}