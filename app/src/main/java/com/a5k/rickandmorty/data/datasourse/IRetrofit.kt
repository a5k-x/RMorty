package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import com.a5k.rickandmorty.data.model.Episode
import retrofit2.Call
import retrofit2.Response

interface IRetrofit {
    suspend fun getCharacter(page:Int): Response<DataModel>

 //   fun getEpisode(id:Int):Call<Episode>
}