package com.a5k.rickandmorty.data.datasourse

import androidx.recyclerview.widget.DiffUtil
import com.a5k.rickandmorty.data.model.Character

class CharacterDiffUtillCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character) =
        oldItem.getId() == newItem.getId()

    override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem.getName() == newItem.getName() &&
                oldItem.getLocation() == newItem.getLocation() &&
                oldItem.getLocation() == newItem.getLocation() &&
                oldItem.getId() == newItem.getId() &&
                oldItem.getEpisode() == newItem.getEpisode() &&
                oldItem.getStatus() == newItem.getStatus() &&
                oldItem.getUrlImage() == newItem.getUrlImage()
}