package br.com.playershub.data

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader("x-rapidapi-key", API_KEY)
            addHeader("x-rapidapi-host", API_HOST)
        }.build()
        return chain.proceed(request)

    }

    companion object {
        const val API_KEY = "282ca6d917msh183fb7e4ef9bfc1p13c201jsn58173c88198c"
        const val API_HOST = "rawg-video-games-database.p.rapidapi.com"
        //const val API_KEY = "378948c72fmsh84f2cfc015272c5p1076f5jsn80fa9cb8555a"
    }
}