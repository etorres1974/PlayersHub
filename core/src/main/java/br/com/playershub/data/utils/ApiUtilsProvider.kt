package br.com.playershub.data.utils

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilsProvider {
    private val logInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun httpClient(authInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logInterceptor)
            .build()
    }

    private fun converterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }

    fun <T> retrofit(
        apiBaseUrl: String,
        apiServiceInterface: Class<T>,
        authInterceptor: Interceptor
    ): T {
        return Retrofit.Builder()
            .client(httpClient(authInterceptor))
            .baseUrl(apiBaseUrl)
            .addConverterFactory(converterFactory())
            .build()
            .create(apiServiceInterface)
    }
}