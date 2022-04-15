package com.a5k.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a5k.rickandmorty.databinding.FragmentCharacterListBinding
import com.a5k.rickandmorty.viewmodel.CharacterListViewModel

class CharacterListFragment : Fragment() {


    private var vb: FragmentCharacterListBinding? = null
    private val livaDataListCharacter:CharacterListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentCharacterListBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLiveData()
    }

    private fun getLiveData() {
        livaDataListCharacter.getLiveDataCharacters().observe(viewLifecycleOwner) {
            listData -> render(listData)
        }
    }

    private fun render(listData: AppState) {
        when(listData) {
            is AppState.Success -> {}
            is AppState.Loading -> {}
            is AppState.Error -> {}
        }
    }

}