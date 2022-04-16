package com.a5k.rickandmorty.view


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.a5k.rickandmorty.R

class MainActivity : AppCompatActivity(), IView {

    private lateinit var navigation: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = Navigation.findNavController(this, R.id.fragment_container)
        initToolbar()

    }

    @SuppressLint("UseSupportActionBar")
    private fun initToolbar() {
        val toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setNavigationOnClickListener {
            navigation.popBackStack()
        }
    }

    override fun getDetailsCharacterFragment(item: Int) {
        val bundle = Bundle()
        bundle.putInt(DetailCharacterInfoFragment.ARG_CHARACTER, item)
        navigation.navigate(
            R.id.action_characterListFragment_to_detailCharacterInfoFragment,
            bundle
        )
    }

    override fun onResume() {
        super.onResume()
        showUpHomeButton(getString(R.string.title_toolbar_list_character), false)

    }

    override fun showUpHomeButton(title: String, flag: Boolean) {
        actionBar?.also {
            it.setDisplayHomeAsUpEnabled(flag)
            it.setDisplayShowHomeEnabled(flag)
            it.title = title
        }

    }


}