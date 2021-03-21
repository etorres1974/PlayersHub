package br.com.playershub.data.rawgGamesApi.entity


import br.com.playershub.domain.entity.Game
import com.google.gson.annotations.SerializedName

data class ApiRawgGame(
    @SerializedName("added")
    val added: Int? = null,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatus? = null,
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("clip")
    val clip: ApiClip? = null,
    @SerializedName("dominant_color")
    val dominantColor: String? = null,
    @SerializedName("esrb_rating")
    val esrbRating: ApiEsrbRating? = null,
    @SerializedName("genres")
    val genres: List<ApiGenre>? = null,
    @SerializedName("id")
    override val id: Int? = null,
    @SerializedName("metacritic")
    val metacritic: Int? = null,
    @SerializedName("name")
    override val name: String? = null,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<PlatformHolder>? = null,
    @SerializedName("platforms")
    val platforms: List<PlatformHolder>? = null,
    @SerializedName("playtime")
    val playtime: Int? = null,
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("rating_top")
    val ratingTop: Int? = null,
    @SerializedName("ratings")
    val ratings: List<ApiRating>? = null,
    @SerializedName("ratings_count")
    val ratingsCount: Int? = null,
    @SerializedName("released")
    val released: String? = null,
    @SerializedName("reviews_count")
    val reviewsCount: Int? = null,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int? = null,
    @SerializedName("saturated_color")
    val saturatedColor: String? = null,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ApiShortScreenshot>? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("stores")
    val stores: List<StoreResponse>? = null,
    @SerializedName("suggestions_count")
    val suggestionsCount: Int? = null,
    @SerializedName("tags")
    val tags: List<ApiTag>? = null,
    @SerializedName("tba")
    val tba: Boolean? = null,
    @SerializedName("updated")
    val updated: String? = null
) : Game