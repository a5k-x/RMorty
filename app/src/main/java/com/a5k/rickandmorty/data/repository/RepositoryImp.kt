package com.a5k.rickandmorty.data.repository

import com.a5k.rickandmorty.data.datasourse.DataSourceRemote
import com.a5k.rickandmorty.data.model.Character

class RepositoryImp(private val dataSource:DataSourceRemote):Repository {

    override suspend fun getCharacterList(page: Int): List<Character>? {
        return dataSource.getCharacterList(page = page)
    }

    override suspend fun getDetailCharacter(id: Int): Character? {
        return dataSource.getDetailCharacter(id)
    }

}