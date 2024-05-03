package com.tahirietrit.rickandmortylookbook.ui.detail

import Episode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahirietrit.rickandmortylookbook.data.model.SingleCharacterResopnese
import com.tahirietrit.rickandmortylookbook.domain.CharactersRepository
import retrofit2.Call
import retrofit2.Response

class CharacterDetailViewModel: ViewModel() {
    val repository = CharactersRepository()
    val episodeData = MutableLiveData<List<Episode>>()

    val characterData = MutableLiveData<SingleCharacterResopnese>()
    fun getCharacterById(characterId: String){
        repository.service.getSingleCharacter(characterId).enqueue(object : retrofit2.Callback<SingleCharacterResopnese> {
            override fun onResponse(
                call: Call<SingleCharacterResopnese>,
                response: Response<SingleCharacterResopnese>
            ) {

                val data = response.body()
                characterData.postValue(response.body())
                if (data != null && data.episode != null) {
                    getEpisodes(getEpisodesPath(data.episode))
                }
            }

            override fun onFailure(call: Call<SingleCharacterResopnese>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
    fun getEpisodes(episodesId: String){
        repository.service.getEpisode(episodesId).enqueue(object : retrofit2.Callback<List<Episode>> {
            override fun onResponse(call: Call<List<Episode>>, response: Response<List<Episode>>) {

                val data = response.body()
                if (data != null){
                    episodeData.postValue(data!!)
                }
            }

            override fun onFailure(call: Call<List<Episode>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
    fun getEpisodesPath(episodes: ArrayList<String>):String{
        var path = ""
        path += episodes.map {
            it.substring(it.lastIndexOf("/")+1, it.length)
        }

        return path
    }
}