package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.Character


class DataSourceRemoteImp(private val retrofit: Retrofit = RetrofitImp()) : DataSourceRemote {

    override suspend fun getCharacterList(page: Int): List<Character>? =
        retrofit.getCharacter(page).results

    override suspend fun getDetailCharacter(id: Int): Character? =
        retrofit.getCharacterDetail(id = id)
}