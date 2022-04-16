package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.Character

interface DataSourceRemote {
    suspend fun getCharacterList(page: Int): List<Character>?
    suspend fun getDetailCharacter(id: Int): Character?
}