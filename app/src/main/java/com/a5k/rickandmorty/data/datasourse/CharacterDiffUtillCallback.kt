package com.a5k.rickandmorty.data.datasourse

import androidx.recyclerview.widget.DiffUtil
import com.a5k.rickandmorty.data.model.Character

class CharacterDiffUtillCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem.id == newItem.id &&
                oldItem.location == newItem.location &&
                oldItem.episode == newItem.episode &&
                oldItem.status == newItem.status &&
                oldItem.image == newItem.image
}