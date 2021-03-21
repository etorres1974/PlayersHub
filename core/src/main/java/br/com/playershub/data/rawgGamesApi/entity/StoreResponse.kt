package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class StoreResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("store")
    val store: ApiStore?
)