package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.model.DataModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImp : com.a5k.rickandmorty.data.datasourse.Retrofit {

    companion object {
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }

    //Получаем объект со списком персонажей
    override suspend fun getCharacter(page: Int): DataModel = getService().getListCharacter(page)

    //Получаем все свойства объекта по id
    override suspend fun getCharacterDetail(id: Int): Character =
        getService().getCharacterDetail(id)


    private fun retrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private fun getService(): ApiSource = retrofit().create(ApiSource::class.java)

}