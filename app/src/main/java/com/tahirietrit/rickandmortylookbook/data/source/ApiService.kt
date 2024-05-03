package com.tahirietrit.rickandmortylookbook.data.source

import Episode
import com.tahirietrit.rickandmortylookbook.data.model.Character
import com.tahirietrit.rickandmortylookbook.data.model.CharactersResponse
import com.tahirietrit.rickandmortylookbook.data.model.SingleCharacterResopnese
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/character")
    fun getCharacters(): Call<CharactersResponse>

    @GET("/api/character/{characterId}")
    fun getSingleCharacter(@Path("characterId") characterId: String): Call<SingleCharacterResopnese>

    @GET("/api/character/?name={characterName}")
    fun getFilterSingleCharacter(@Path("characterName") characterName: String): Call<SingleCharacterResopnese>

    @GET("/api/episode/{episodeID}")
    fun getEpisode(@Path("episodeID") episodes: String): Call<List<Episode>>

}