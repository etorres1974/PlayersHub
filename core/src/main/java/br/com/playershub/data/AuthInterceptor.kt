package br.com.playershub.data

import br.com.playershub.data.utils.VIDEO_GAME_DB_HOST
import br.com.playershub.data.utils.VIDEO_GAME_DB_KEY
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader("x-rapidapi-key", VIDEO_GAME_DB_KEY)
            addHeader("x-rapidapi-host", VIDEO_GAME_DB_HOST)
        }.build()
        return chain.proceed(request)
    }
}