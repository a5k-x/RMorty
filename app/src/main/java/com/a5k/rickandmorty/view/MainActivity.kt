package com.a5k.rickandmorty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.a5k.rickandmorty.R
import com.a5k.rickandmorty.data.model.Character

class MainActivity : AppCompatActivity(),IView {

    lateinit var navigation: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = Navigation.findNavController(this, R.id.fragment_container)

    }

    override fun getDetailsCharacterFragment(item:Character) {
        val bundle = Bundle()
        bundle.putParcelable(DetailCharacterInfoFragment.ARG_PARAM1,item)
        navigation.navigate(R.id.action_characterListFragment_to_detailCharacterInfoFragment,bundle)
    }


}