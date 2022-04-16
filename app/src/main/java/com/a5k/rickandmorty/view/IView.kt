package com.a5k.rickandmorty.view


interface IView {
    fun getDetailsCharacterFragment(item: Int)
    fun showUpHomeButton(title: String, flag: Boolean)
}