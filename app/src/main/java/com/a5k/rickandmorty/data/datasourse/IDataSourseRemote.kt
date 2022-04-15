package com.a5k.rickandmorty.data.datasourse

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.view.AppState

interface IDataSourseRemote {
    suspend fun getCharacterList(page:Int):List<Character>?

  //  fun getDetailCharacter(liveData: MutableLiveData<AppState>,idCharacter:Int)


}