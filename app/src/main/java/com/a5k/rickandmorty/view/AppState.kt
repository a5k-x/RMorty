package com.a5k.rickandmorty.view

import com.a5k.rickandmorty.data.model.Character

sealed class AppState{
    data class SuccessListCharacter(val CharacterList: List<Character>):AppState()
    data class SuccessDetailCharacter(val CharacterList: Character):AppState()
    data class Loading(var load: Int):AppState()
    data class Error(val error:Throwable):AppState()
}
