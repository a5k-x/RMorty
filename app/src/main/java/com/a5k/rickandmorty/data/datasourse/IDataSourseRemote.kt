package com.a5k.rickandmorty.data.datasourse

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.view.AppState

interface IDataSourseRemote {
    fun getCharacterList(liveData: MutableLiveData<AppState>,page:Int)

    fun getDetailCharacter(liveData: MutableLiveData<AppState>,idCharacter:Int)


}