package br.com.playershub.data.rawgGamesApi.entity


import br.com.playershub.domain.entity.GameDetails
import com.google.gson.annotations.SerializedName

data class ApiRawgGameDetails(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("description")
    override val description: String,
    @SerializedName("name")
    override val name: String,
    @SerializedName("background_image")
    override val image: String?,
    @SerializedName("saturated_color")
    val saturated_color: String?,
    @SerializedName("dominant_color")
    val dominant_color: String?
) : GameDetails