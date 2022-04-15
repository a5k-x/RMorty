package com.a5k.rickandmorty.data.repository

import com.a5k.rickandmorty.data.model.Character

interface IRepository {
    suspend fun getCharacterList(page:Int):List<Character>?

    //fun getDetailCharacter(liveData: MutableLiveData<AppState>,idCharacter:Int)
}