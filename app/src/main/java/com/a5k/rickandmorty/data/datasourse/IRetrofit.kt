package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import retrofit2.Call

interface IRetrofit {
    fun getCharacter(page:Int): Call<DataModel>

    fun getEpisode(id:Int):Call<DataModel.Episode>
}