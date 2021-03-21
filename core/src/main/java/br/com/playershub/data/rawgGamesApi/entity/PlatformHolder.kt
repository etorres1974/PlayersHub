package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class PlatformHolder(
    @SerializedName("platform")
    val platform: ApiPlatform?,
    @SerializedName("released_at")
    val releasedAt: String?
)