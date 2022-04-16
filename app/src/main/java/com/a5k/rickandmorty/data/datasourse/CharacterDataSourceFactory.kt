package com.a5k.rickandmorty.data.datasourse

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.repository.RepositoryImp
import kotlinx.coroutines.CoroutineScope

class CharacterDataSourceFactory(
    private val repositoryImp: RepositoryImp,
    private val coroutineScope: CoroutineScope
) : DataSource.Factory<Int, Character>() {

    private val liveDataSource = MutableLiveData<CharacterItemKeyedDataSource>()

    override fun create(): DataSource<Int, Character> {
        val source = CharacterItemKeyedDataSource(
            repositoryImp, coroutineScope
        )
        liveDataSource.postValue(source)
        return source
    }
}