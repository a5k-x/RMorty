package com.a5k.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.a5k.rickandmorty.data.datasourse.CharacterDataSourceFactory
import com.a5k.rickandmorty.data.datasourse.DataSourceRemote
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class CharacterListViewModel:ViewModel() {


    private val scope = CoroutineScope(Dispatchers.IO)

    private val factory = CharacterDataSourceFactory(Repository(DataSourceRemote()),scope)
    private val config = Config(
        pageSize = 20,
        prefetchDistance = 5,
        enablePlaceholders = false
    )
    private val characters: LiveData<PagedList<Character>> = LivePagedListBuilder(factory,config).build()

    fun getLiveDataCharacters() = characters



}