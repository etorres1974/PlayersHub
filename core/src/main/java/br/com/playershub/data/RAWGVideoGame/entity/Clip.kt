package br.com.playershub.data.RAWGVideoGame.entity


import com.google.gson.annotations.SerializedName

data class Clip(
    @SerializedName("clip")
    val clip: String?,
    @SerializedName("preview")
    val preview: String?,
    @SerializedName("video")
    val video: String?
)