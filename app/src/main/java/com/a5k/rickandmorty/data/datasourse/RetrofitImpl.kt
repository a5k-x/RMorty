package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl:IRetrofit {

    private fun getService():ApiSource{
        return retrofit().create(ApiSource::class.java)
    }

    private fun retrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    override fun getCharacter(page: Int): Call<DataModel> {
        return getService().getListCharacter(page)
    }

    companion object{
        private const val BASE_URL = "https://rickandmortyapi.com/api"
    }
}