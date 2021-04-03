package br.com.playershub.data.rawgGamesApi.entity.games


import com.google.gson.annotations.SerializedName

data class Requirements(
    @SerializedName("minimum")
    val minimum: String? = null,
    @SerializedName("recommended")
    val recommended: String? = null
)