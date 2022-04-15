package com.a5k.rickandmorty.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.databinding.FragmentDetailCharacterInfoBinding


class DetailCharacterInfoFragment : Fragment() {

    private var param1: Character? = null

    private var vb:FragmentDetailCharacterInfoBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getParcelable(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentDetailCharacterInfoBinding.inflate(inflater,container,false)
        return vb?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (param1!=null){
            vb?.imageContainer?.load(param1?.getUrlImage())
            vb?.nameCharacterDetails?.text =param1!!.getName() ?: "null"

        }
    }

    companion object {
        const val ARG_PARAM1 = "CHARACTER_TO"

    }
}