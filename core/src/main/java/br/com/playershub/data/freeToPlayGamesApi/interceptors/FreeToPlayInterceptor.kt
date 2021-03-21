package br.com.playershub.data.rawgGamesApi.interceptors

import br.com.playershub.data.utils.FREE_TO_PLAY_HOST
import br.com.playershub.data.utils.FREE_TO_PLAY_KEY
import okhttp3.Interceptor
import okhttp3.Response

class FreeToPlayInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader("x-rapidapi-key", FREE_TO_PLAY_KEY)
            addHeader("x-rapidapi-host", FREE_TO_PLAY_HOST)
            addHeader("userQueryString", "true")
        }.build()
        return chain.proceed(request)
    }
}