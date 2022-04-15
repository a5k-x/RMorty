package com.a5k.rickandmorty.data.repository

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.view.AppState

interface IRepository {
    fun getCharacterList(liveData: MutableLiveData<AppState>,page:Int)

    fun getDetailCharacter(liveData: MutableLiveData<AppState>,idCharacter:Int)
}