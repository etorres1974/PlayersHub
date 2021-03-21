package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class ApiRating(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("percent")
    val percent: Double?,
    @SerializedName("title")
    val title: String?
)