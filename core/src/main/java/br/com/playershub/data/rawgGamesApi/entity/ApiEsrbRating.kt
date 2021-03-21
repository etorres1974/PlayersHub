package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class ApiEsrbRating(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("slug")
    val slug: String?
)