package com.a5k.rickandmorty.view

import com.a5k.rickandmorty.data.model.DataModel

sealed class AppState{
    data class Success(val CharacterList: DataModel):AppState()
    data class Loading(var load: Int):AppState()
    data class Error(val error:Throwable):AppState()
}
