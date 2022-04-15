package com.a5k.rickandmorty.data.repository

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.data.datasourse.IDataSourseRemote
import com.a5k.rickandmorty.view.AppState

class Repository(private val dataSource:IDataSourseRemote):IRepository {
    override fun getCharacterList(liveData: MutableLiveData<AppState>, page: Int) {
       dataSource.getCharacterList(liveData, page)
    }

    override fun getDetailCharacter(liveData: MutableLiveData<AppState>, idCharacter: Int) {
       dataSource.getDetailCharacter(liveData, idCharacter)
    }

}