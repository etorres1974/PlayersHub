package br.com.playershub.data.rawgGamesApi.entity.games


import br.com.playershub.data.rawgGamesApi.sources.PagedResponse
import br.com.playershub.domain.entity.Game
import com.google.gson.annotations.SerializedName

data class ApiGamesResponse(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<ApiGame>?
) : PagedResponse<Game> {
    override fun getData(): List<Game>? = results

    override fun getPrevious(): Int? {
        return  previous?.split("page=")?.get(1)?.split("&")?.get(0)?.toIntOrNull()
    }

    override fun getNext(): Int? {
        return  next?.split("page=")?.get(1)?.split("&")?.get(0)?.toIntOrNull()
    }
}

