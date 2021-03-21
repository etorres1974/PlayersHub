package br.com.playershub.data.rawgGamesApi.entity


import com.google.gson.annotations.SerializedName

data class ApiClip(
    @SerializedName("clip")
    val clip: String?,
    @SerializedName("preview")
    val preview: String?,
    @SerializedName("video")
    val video: String?
)