package com.a5k.rickandmorty.data.datasourse
import com.a5k.rickandmorty.data.model.Character


class DataSourceRemote(private val retrofit:IRetrofit= RetrofitImpl()):IDataSourseRemote {


    override suspend fun getCharacterList(page: Int): List<Character>? {

       val data = retrofit.getCharacter(page)
       return data.body()?.results

    }



}