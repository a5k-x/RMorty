package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.model.DataModel

interface Retrofit {
    suspend fun getCharacter(page: Int): DataModel

    suspend fun getCharacterDetail(id: Int): Character
}