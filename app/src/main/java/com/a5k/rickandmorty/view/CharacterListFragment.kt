package com.a5k.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.PagedList
import com.a5k.rickandmorty.R
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.databinding.FragmentCharacterListBinding
import com.a5k.rickandmorty.view.adapter.MainAdapter
import com.a5k.rickandmorty.view.adapter.OnClickHandler
import com.a5k.rickandmorty.viewmodel.CharacterListViewModel

class CharacterListFragment : Fragment() {

    private var vb: FragmentCharacterListBinding? = null
    private val livaDataListCharacter:CharacterListViewModel by viewModels()
    private var mainAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentCharacterListBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMainAdapter()
        initListenerItem()
        getLiveData()
    }

    private fun initListenerItem() {
        mainAdapter.initListener(object :OnClickHandler{
            override fun onClick(item: Int) {
                (activity as IView).getDetailsCharacterFragment(item)
            }
        })
    }

    private fun initMainAdapter() {
        vb?.recyclerContainer.apply {
            this?.adapter = mainAdapter
        }
    }

    private fun getLiveData() {
        livaDataListCharacter.getLiveDataCharacters().observe(viewLifecycleOwner) {
            listData -> render(listData)
        }

    }

    private fun render(listData: PagedList<Character>) {
        mainAdapter.submitList(listData)
    }

    override fun onResume() {
        super.onResume()
        (activity as IView).showUpHomeButton(getString(R.string.title_toolbar_list_character), false)
    }

}