package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import com.a5k.rickandmorty.data.model.Episode
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSource {
    //https://rickandmortyapi.com/api/character/?page=3

        @GET("character")
       suspend fun getListCharacter(
            @Query("page") page: Int
        ): Response<DataModel>

        @GET("character/{id}")
        fun getCharacterDetail(
            @Path("id") id: Int
        ): Response<Character>

}