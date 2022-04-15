package com.a5k.rickandmorty.data.datasourse

import com.a5k.rickandmorty.data.model.DataModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl:IRetrofit {

    private fun getService():ApiSource{
        return retrofit().create(ApiSource::class.java)
    }

    private fun retrofit():Retrofit{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
           // .client(client.build())
            .build()
    }

    override suspend fun getCharacter(page: Int): Response<DataModel> {
        return getService().getListCharacter(page)
    }

    companion object{
        private const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}