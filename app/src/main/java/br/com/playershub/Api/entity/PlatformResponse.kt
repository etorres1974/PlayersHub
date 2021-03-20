package br.com.playershub.Api.entity


import com.google.gson.annotations.SerializedName

data class PlatformResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val platforms: List<ApiPlatform>?
)