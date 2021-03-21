package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class ApiShortScreenshot(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?
)