package br.com.playershub.data.RAWGVideoGame.entity


import com.google.gson.annotations.SerializedName

data class GameResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<ApiGame>
)