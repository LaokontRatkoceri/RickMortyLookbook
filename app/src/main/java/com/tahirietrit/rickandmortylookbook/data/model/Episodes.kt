package com.tahirietrit.rickandmortylookbook.data.model

import com.google.gson.annotations.SerializedName

data class Episodes (

//    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<EpisodesRes> = arrayListOf()

)

data class EpisodesRes (

    @SerializedName("id"         ) var id         : Int?              = null,
    @SerializedName("name"       ) var name       : String?           = null,
    @SerializedName("air_date"   ) var airDate    : String?           = null,
    @SerializedName("episode"    ) var episode    : String?           = null,
    @SerializedName("characters" ) var characters : ArrayList<String> = arrayListOf(),
    @SerializedName("url"        ) var url        : String?           = null,
    @SerializedName("created"    ) var created    : String?           = null

)