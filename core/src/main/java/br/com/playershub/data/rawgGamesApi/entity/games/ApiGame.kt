package br.com.playershub.data.rawgGamesApi.entity.games


import br.com.playershub.domain.entity.Game
import com.google.gson.annotations.SerializedName

data class ApiGame(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    override val name: String,
    @SerializedName("background_image")
    override val image: String?,

    @SerializedName("added")
    val added: Int?,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRating?,
    @SerializedName("metacritic")
    val metacritic: Int?,
    @SerializedName("platforms")
    val platforms: List<Platform>?,
    @SerializedName("rating")
    val rating: Float?,
    @SerializedName("rating_top")
    val ratingTop: Int?,
    @SerializedName("ratings_count")
    val ratingsCount: Int?,
    @SerializedName("released")
    val released: String?,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int?,
    @SerializedName("tba")
    val tba: Boolean?,
    @SerializedName("updated")
    val updated: String?
) : Game