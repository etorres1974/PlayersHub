package br.com.playershub.data.rawgGamesApi.entity.games


import com.google.gson.annotations.SerializedName

data class PlatformInfo(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("slug")
    val slug: String? = null
)