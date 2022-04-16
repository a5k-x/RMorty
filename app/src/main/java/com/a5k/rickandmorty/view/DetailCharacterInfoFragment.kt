package com.a5k.rickandmorty.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.ImageLoader
import coil.load
import com.a5k.rickandmorty.R
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.databinding.FragmentDetailCharacterInfoBinding
import com.a5k.rickandmorty.viewmodel.CharacterListViewModel


class DetailCharacterInfoFragment : Fragment() {

    companion object {
        const val ARG_CHARACTER = "CHARACTER_TO"
        private const val STATUS_ALIVE = "Alive"
        private const val STATUS_DEAD = "Dead"
    }

    private var idCharacter: Int? = null

    private var vb: FragmentDetailCharacterInfoBinding? = null
    private val liveDataDetailCharacter: CharacterListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idCharacter = it.getInt(ARG_CHARACTER)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentDetailCharacterInfoBinding.inflate(inflater, container, false)
        return vb?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLiveDataDetailCharacter()
    }

    private fun getLiveDataDetailCharacter() {
        liveDataDetailCharacter.liveDataDetailCharacter.observe(viewLifecycleOwner) { dataDetailCharacter ->
            render(
                dataDetailCharacter
            )
        }
        idCharacter?.let { liveDataDetailCharacter.getDetailCharacter(it) }
    }

    private fun render(dataDetailCharacter: AppState) {
        when (dataDetailCharacter) {
            is AppState.SuccessDetailCharacter -> {
                workField(dataDetailCharacter.item)
            }
            is AppState.Error -> {
                Toast.makeText(
                    requireContext(),
                    dataDetailCharacter.error.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    @SuppressLint("SetTextI18n")
    private fun workField(item: Character) {
        loadImage(item)
        vb?.nameCharacterDetails?.text = getString(R.string.name_character) + " " + item.name
        vb?.speciesCharacterDetails?.text =
            getString(R.string.type_character) + " " + item.type

        val statusCharacter = getString(R.string.status_character) + " " + item.status
        when (item.status) {
            STATUS_ALIVE -> {
                currentStatusCharacterColor(statusCharacter, Color.GREEN)
            }
            STATUS_DEAD -> {
                currentStatusCharacterColor(statusCharacter, Color.RED)
            }
            else -> currentStatusCharacterColor(statusCharacter, Color.GRAY)
        }

        vb?.locationCharacterDetails?.text =
            getString(R.string.location_character) + " " + item.location.name
        vb?.countEpisodeCharacterDetails?.text =
            getString(R.string.count_episode_character) + " " + item.episode.size.toString()
    }

    //Загрузка изображения
    private fun loadImage(item: Character) {
        val imageLoader = ImageLoader.Builder(requireContext())
            .crossfade(true)
            .error(R.drawable.icon_error)
            .placeholder(R.drawable.icon_download_image)
            .build()
        vb?.imageContainer?.load(item.image, imageLoader)
    }

    private fun currentStatusCharacterColor(textStatus: String, color: Int) {
        val text = SpannableStringBuilder(textStatus)
        val style = ForegroundColorSpan(color)
        text.setSpan(style, 8, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        vb?.statusCharacterDetails?.text = text
    }

    override fun onResume() {
        super.onResume()
        (activity as IView).showUpHomeButton(
            getString(R.string.title_toolbar_detail_character),
            true
        )
    }


}