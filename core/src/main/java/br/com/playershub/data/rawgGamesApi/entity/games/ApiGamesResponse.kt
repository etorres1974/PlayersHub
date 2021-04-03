package br.com.playershub.data.rawgGamesApi.entity.games


import com.google.gson.annotations.SerializedName

data class ApiGamesResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<ApiGame>?
)