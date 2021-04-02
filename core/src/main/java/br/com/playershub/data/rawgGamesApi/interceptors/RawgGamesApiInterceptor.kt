package br.com.playershub.data.rawgGamesApi.interceptors

import br.com.playershub.data.utils.API_KEY
import br.com.playershub.data.utils.VIDEO_GAME_DB_HOST
import br.com.playershub.data.utils.VIDEO_GAME_DB_KEY
import okhttp3.Interceptor
import okhttp3.Response

class RawgGamesApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        val url = originalHttpUrl.newBuilder().addQueryParameter("key", API_KEY).build()
        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}