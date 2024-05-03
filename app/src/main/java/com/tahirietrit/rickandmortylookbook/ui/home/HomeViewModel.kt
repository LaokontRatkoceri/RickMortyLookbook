package com.tahirietrit.rickandmortylookbook.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.CharactersResponse
import com.tahirietrit.rickandmortylookbook.domain.CharactersRepository
import retrofit2.Call
import retrofit2.Response

class HomeViewModel : ViewModel() {
    val charactersList = MutableLiveData<List<Character>>()
    private val repository = CharactersRepository()

    init {
        getCharacters()
    }

    fun getCharacters() {
        repository.service.getCharacters().enqueue(object : retrofit2.Callback<CharactersResponse> {
            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                charactersList.postValue(response.body()!!.results)
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}