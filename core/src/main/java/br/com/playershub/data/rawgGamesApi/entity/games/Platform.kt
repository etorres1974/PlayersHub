package br.com.playershub.data.rawgGamesApi.entity.games


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("platform")
    val platform: PlatformInfo? = null,
    @SerializedName("released_at")
    val releasedAt: String? = null,
    @SerializedName("requirements")
    val requirements: Requirements? = null
)