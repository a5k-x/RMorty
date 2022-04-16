package com.a5k.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.a5k.rickandmorty.data.datasourse.CharacterDataSourceFactory
import com.a5k.rickandmorty.data.datasourse.DataSourceRemoteImp
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.repository.RepositoryImp
import com.a5k.rickandmorty.view.AppState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterListViewModel:ViewModel() {

    companion object{
        private const val ERROR_LOAD = "Ошибка загрузки"
    }

    private val scope = CoroutineScope(Dispatchers.IO)
    private var _liveDataDetailCharacter = MutableLiveData<AppState>()
    val liveDataDetailCharacter:LiveData<AppState> = _liveDataDetailCharacter
    private val factory = CharacterDataSourceFactory(RepositoryImp(DataSourceRemoteImp()),scope)
    private val config = Config(
        pageSize = 20,
        prefetchDistance = 5,
        enablePlaceholders = false
    )
    private val characters: LiveData<PagedList<Character>> = LivePagedListBuilder(factory,config).build()

    fun getLiveDataCharacters() = characters



    fun getDetailCharacter(id:Int){

        scope.launch {
            val data = RepositoryImp(DataSourceRemoteImp()).getDetailCharacter(id = id)
            if (data != null) { _liveDataDetailCharacter.postValue(AppState.SuccessDetailCharacter(data))}
            else { _liveDataDetailCharacter.postValue(AppState.Error(Throwable(ERROR_LOAD)))}
        }
    }


}