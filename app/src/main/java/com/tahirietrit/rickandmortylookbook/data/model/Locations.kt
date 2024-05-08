package com.tahirietrit.rickandmortylookbook.data.model
import com.google.gson.annotations.SerializedName


data class LocationRes (

//    @SerializedName("info"    ) var info    : Info?              = Info(),
    @SerializedName("results" ) var results : ArrayList<Locations> = arrayListOf()

)


data class Locations (

    @SerializedName("id"        ) var id        : Int?              = null,
    @SerializedName("name"      ) var name      : String?           = null,
    @SerializedName("type"      ) var type      : String?           = null,
    @SerializedName("dimension" ) var dimension : String?           = null,
    @SerializedName("residents" ) var residents : ArrayList<String> = arrayListOf(),
    @SerializedName("url"       ) var url       : String?           = null,
    @SerializedName("created"   ) var created   : String?           = null

)