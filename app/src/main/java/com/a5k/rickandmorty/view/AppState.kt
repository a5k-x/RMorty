package com.a5k.rickandmorty.view

import com.a5k.rickandmorty.data.model.Character

sealed interface AppState {
    data class SuccessDetailCharacter(val item: Character) : AppState
    data class Error(val error: Throwable) : AppState
}
