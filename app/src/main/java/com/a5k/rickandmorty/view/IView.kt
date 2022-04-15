package com.a5k.rickandmorty.view

import com.a5k.rickandmorty.data.model.Character

interface IView {

    fun getDetailsCharacterFragment(item:Character)
}