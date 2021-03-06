package com.a5k.rickandmorty.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.a5k.rickandmorty.data.datasourse.CharacterDiffUtillCallback
import com.a5k.rickandmorty.data.model.Character

import com.a5k.rickandmorty.databinding.ItemCharacterBinding

class MainAdapter:PagedListAdapter<Character,MainAdapter.ViewHolder>(CharacterDiffUtillCallback()) {

    lateinit var onClickHand: OnClickHandler

    fun initListener(listener:OnClickHandler){
        this.onClickHand = listener
    }

    inner class ViewHolder(val vb:ItemCharacterBinding): RecyclerView.ViewHolder(vb.root) {
        fun bind(item: Character) {
            vb.nameCharacter.text = item.name
            vb.typeCharacter.text = item.type
            vb.genderCharacter.text = item.gender
            vb.imageCharacter.load(item.image)
            itemView.setOnClickListener { onClickHand.onClick(item.id) }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}

interface OnClickHandler{
    fun onClick(item: Int)
}