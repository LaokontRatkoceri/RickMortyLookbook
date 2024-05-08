package com.tahirietrit.rickandmortylookbook.ui.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.CharactersResponse
import com.tahirietrit.rickandmortylookbook.data.model.EpisodesRes
import com.tahirietrit.rickandmortylookbook.data.model.Location
import com.tahirietrit.rickandmortylookbook.data.model.LocationRes
import com.tahirietrit.rickandmortylookbook.data.model.Locations
import com.tahirietrit.rickandmortylookbook.data.model.SingleLocation
import com.tahirietrit.rickandmortylookbook.domain.CharactersRepository
import retrofit2.Call
import retrofit2.Response

class LocationViewModel : ViewModel() {
    val LocationsList = MutableLiveData<List<Locations>>()
    private val repository = CharactersRepository()
    val LocationData = MutableLiveData<SingleLocation>()
    val characterData = MutableLiveData<List<Character>>()


    init {
        getAllLocations()
    }
    fun getAllLocations() {
        repository.service.getAllLocations().enqueue(object : retrofit2.Callback<LocationRes> {
            override fun onResponse(
                call: Call<LocationRes>,
                response: Response<LocationRes>
            ) {
                LocationsList.postValue(response.body()!!.results)
            }

            override fun onFailure(call: Call<LocationRes>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    fun getLocationById(locationId: String){
        repository.service.getLocation(locationId).enqueue(object : retrofit2.Callback<SingleLocation> {
            override fun onResponse(
                call: Call<SingleLocation>,
                response: Response<SingleLocation>
            ) {


                val data = response.body()
                LocationData.postValue(response.body()!!)
                if (data != null && data.residents != null){
                    getCharactersById(getCharacterPath(data.residents))
                }
            }

            override fun onFailure(call: Call<SingleLocation>, t: Throwable) {
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
    fun getCharacterPath(character: ArrayList<String>):String{
        var path = ""
        path += character.map {
            it.substring(it.lastIndexOf("/")+1, it.length)
        }

        return path
    }

}