package com.a5k.rickandmorty.data.datasourse

import androidx.paging.ItemKeyedDataSource
import com.a5k.rickandmorty.data.model.Character
import com.a5k.rickandmorty.data.repository.RepositoryImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class CharacterItemKeyedDataSource(
    private val repositoryImp: RepositoryImp,
    private val coroutineScope: CoroutineScope
) : ItemKeyedDataSource<Int, Character>() {
    override fun getKey(item: Character): Int {
        return item.id
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Character>) {
        coroutineScope.launch {
            val page = params.key / 20 + 1
            val characters = repositoryImp.getCharacterList(page)
            if (characters != null) {
                callback.onResult(characters)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Character>) {

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Character>
    ) {
        coroutineScope.launch {
            val characters = repositoryImp.getCharacterList(0)
            if (characters != null) {
                callback.onResult(characters)
            }
        }
    }
}