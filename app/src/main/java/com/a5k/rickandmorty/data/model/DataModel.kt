package com.a5k.rickandmorty.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

data class DataModel(val results: List<Character>) {
}

@Parcelize
class Character(
    private val id: Int,
    private val name: String,
    private val status: String,
    private val type: String,
    private val gender:String,
    private val location: Location,
    private val image: String,
    private val episode: List<String>,
) : Parcelable {
    fun getId() = id
    fun getUrlImage() = image
    fun getName() = name
    fun getType() = type
    fun getGender() = gender
    fun getStatus() = status
    fun getLocation(): Location = location
    fun getEpisode(): List<String> = episode

}
    //Имя и ссылка на последнюю известную конечную точку местоположения персонажа.
    @Parcelize
  data class Location(
        private val name: String,
        private val url: String,

        ) : Parcelable {
        fun getName() = name
        fun getUrl() = url
    }

  data class Episode(
        private val name: String,
        private val air_date: String,
        private var dataNew: Date? = null

    ) {
        fun getName() = name
        fun getData() = air_date
        fun getDataNew() = dataNew

        //из строки  объект дата, для сортировки
        fun getDataNew(air_date: String) {
            val simpleData = SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH)
            dataNew = simpleData.parse(air_date)

        }
    }

