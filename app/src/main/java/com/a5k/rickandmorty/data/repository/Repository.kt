package com.a5k.rickandmorty.data.repository

import com.a5k.rickandmorty.data.model.Character

interface Repository {
    suspend fun getCharacterList(page:Int):List<Character>?

    suspend fun getDetailCharacter(id:Int):Character?
}