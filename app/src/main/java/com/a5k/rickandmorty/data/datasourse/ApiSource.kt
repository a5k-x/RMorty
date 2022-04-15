package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSource {
    //https://rickandmortyapi.com/api/character/?page=3

        @GET("character")
        fun getListCharacter(
            @Query("page") page: Int
        ): Call<DataModel>

        @GET("character/{id}")
        fun getCharacter(
            @Path("id") id: Int
        ): Call<Character>

        @GET("episode/{id}")
        fun getEpisode(
            @Path("id") id: List<Int>
        ): Call<List<DataModel.Episode>>

}