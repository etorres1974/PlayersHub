package br.com.playershub.domain.entity

interface GameDetails {
    val id: Int
    val name: String?
    val image: String?
    val description: String
    //val clip: ApiClip?,
    //val esrbRating: ApiEsrbRating?,
    //val genres: List<ApiGenre>?,
    //val parentPlatforms: List<PlatformHolder>?,
    //val platforms: List<PlatformHolder>?,
    //val ratings: List<ApiRating>?,
    //val shortScreenshots: List<ApiShortScreenshot>?,
    //val slug: String?,
    //val stores: List<StoreResponse>?,
    //val tags: List<ApiTag>?
}