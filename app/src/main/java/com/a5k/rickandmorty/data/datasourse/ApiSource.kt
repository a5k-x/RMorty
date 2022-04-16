package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.model.DataModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiSource {
    //https://rickandmortyapi.com/api/character/?page=3
    //https://rickandmortyapi.com/api/character/3

        @GET("character")
       suspend fun getListCharacter(
            @Query("page") page: Int
        ): DataModel

        @GET("character/{id}")
       suspend fun getCharacterDetail(
            @Path("id") id: Int
        ): Character

}