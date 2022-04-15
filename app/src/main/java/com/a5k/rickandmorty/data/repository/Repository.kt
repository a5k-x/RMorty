package com.a5k.rickandmorty.data.repository

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.data.datasourse.IDataSourseRemote
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.view.AppState

class Repository(private val dataSource:IDataSourseRemote):IRepository {

    override suspend fun getCharacterList(page: Int): List<Character>? {
        return dataSource.getCharacterList(page = page)
    }

}