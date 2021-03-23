package br.com.playershub.data.freeToPlayGamesApi.entity


import br.com.playershub.domain.entity.Game
import com.google.gson.annotations.SerializedName

data class ApiFreeToPlayGame(
    @SerializedName("developer")
    val developer: String? = null,
    @SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String? = null,
    @SerializedName("game_url")
    val gameUrl: String? = null,
    @SerializedName("genre")
    val genre: String? = null,
    @SerializedName("id")
    override val id: Int,
    @SerializedName("platform")
    val platform: String? = null,
    @SerializedName("publisher")
    val publisher: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("short_description")
    val shortDescription: String? = null,
    @SerializedName("thumbnail")
    override val image: String? = null,
    @SerializedName("title")
    override val name: String? = null
) : Game