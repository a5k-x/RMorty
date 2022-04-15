package com.a5k.rickandmorty.data.datasourse

import androidx.lifecycle.MutableLiveData
import com.a5k.rickandmorty.data.model.DataModel
import com.a5k.rickandmorty.view.AppState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataSourceRemote(private val retrofit:IRetrofit= RetrofitImpl()):IDataSourseRemote {

    override fun getCharacterList(liveData: MutableLiveData<AppState>, page: Int) {

       val data = retrofit.getCharacter(page)
        data.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.body() != null)
                {
                    when (response.code()){
                        200 -> {liveData.postValue(AppState.Success(response.body()!!))}
                    }
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                liveData.postValue(AppState.Error(Throwable(t)))
            }

        })
    }

    override fun getDetailCharacter(liveData: MutableLiveData<AppState>, idCharacter: Int) {

    }

}