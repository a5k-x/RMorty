package com.a5k.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a5k.rickandmorty.view.AppState

class CharacterListViewModel:ViewModel() {

    private val liveDataCharacters:LiveData<AppState> = MutableLiveData<AppState>()
    private val _liveDataCharacters:LiveData<AppState> = liveDataCharacters

    fun getLiveDataCharacters() = _liveDataCharacters
}