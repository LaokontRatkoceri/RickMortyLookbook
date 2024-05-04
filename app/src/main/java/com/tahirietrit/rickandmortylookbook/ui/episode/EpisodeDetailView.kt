package com.tahirietrit.rickandmortylookbook.ui.episode

import Episode
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.Episodes
import com.tahirietrit.rickandmortylookbook.data.model.EpisodesRes
import com.tahirietrit.rickandmortylookbook.domain.CharactersRepository
import retrofit2.Call
import retrofit2.Response

class EpisodeDetailView : ViewModel() {
    private val repository = CharactersRepository()
    val episodeData = MutableLiveData<Episode>()
    val episodesList = MutableLiveData<List<EpisodesRes>>()

    val characterData = MutableLiveData<List<Character>>()
init {
    getAllEpisodes()
}

    fun getEpisodById(episodeId: String){
        repository.service.Episode(episodeId).enqueue(object : retrofit2.Callback<Episode> {
            override fun onResponse(
                call: Call<Episode>,
                response: Response<Episode>
            ) {


                val data = response.body()
                episodeData.postValue(response.body()!!)
                if (data != null && data.characters != null){
                    getCharactersById(getCharacterPath(data.characters))
                }
            }

            override fun onFailure(call: Call<Episode>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
    fun getCharactersById(characterId: String) {
        repository.service.getCharacters(characterId).enqueue(object : retrofit2.Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                val data = response.body()
                characterData.postValue(response.body())

                if (data != null) {
                    characterData.postValue(data!!)
                }
            }


            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                t.printStackTrace()
            }


        })
    }
    fun getAllEpisodes(){
        repository.service.getAllEpisodes().enqueue(object : retrofit2.Callback<Episodes> {
            override fun onResponse(
                call: Call<Episodes>,
                response: Response<Episodes>
            ) {
                episodesList.postValue(response.body()!!.results)

            }

            override fun onFailure(call: Call<Episodes>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
    fun getCharacterPath(character: ArrayList<String>):String{
        var path = ""
        path += character.map {
            it.substring(it.lastIndexOf("/")+1, it.length)
        }

        return path
    }
}