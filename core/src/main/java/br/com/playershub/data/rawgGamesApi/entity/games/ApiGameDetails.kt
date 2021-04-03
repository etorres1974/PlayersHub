package br.com.playershub.data.rawgGamesApi.entity.games


import br.com.playershub.domain.entity.GameDetails
import com.google.gson.annotations.SerializedName

data class ApiGameDetails(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    override val name: String? ,
    @SerializedName("description")
    override val description: String? ,
    @SerializedName("background_image")
    override val image : String? ,
    @SerializedName("background_image_additional")
    val imageAdditional: String? ,

    @SerializedName("achievements_count")
    val achievementsCount: Int? ,
    @SerializedName("added")
    val added: Int? ,
    @SerializedName("additions_count")
    val additionsCount: Int? ,
    @SerializedName("alternative_names")
    val alternativeNames: List<String>? ,
    @SerializedName("creators_count")
    val creatorsCount: Int? ,
    @SerializedName("esrb_rating")
    val esrbRating: EsrbRating? ,
    @SerializedName("game_series_count")
    val gameSeriesCount: Int? ,
    @SerializedName("metacritic")
    val metacritic: Int? ,
    @SerializedName("movies_count")
    val moviesCount: Int? ,
    @SerializedName("name_original")
    val nameOriginal: String? ,
    @SerializedName("parents_count")
    val parentsCount: Int? ,
    @SerializedName("platforms")
    val platforms: List<Platform>? ,
    @SerializedName("rating")
    val rating: Float? ,
    @SerializedName("rating_top")
    val ratingTop: Int? ,
    @SerializedName("ratings_count")
    val ratingsCount: Int? ,
    @SerializedName("released")
    val released: String? ,
    @SerializedName("screenshots_count")
    val screenshotsCount: Int? ,
    @SerializedName("slug")
    val slug: String? ,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int? ,
    @SerializedName("tba")
    val tba: Boolean? ,
    @SerializedName("updated")
    val updated: String? ,
    @SerializedName("website")
    val website: String?
) : GameDetails