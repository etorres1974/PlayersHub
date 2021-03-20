package br.com.playershub.data.utils

import br.com.playershub.data.AuthInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilsProvider {
    private val authInterceptor = AuthInterceptor()
    private val logInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logInterceptor)
            .build()
    }

    private fun converterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }

    fun <T> retrofit(apiBaseUrl : String , apiServiceInterface : Class<T> ): T {
       return Retrofit.Builder()
            .client(httpClient())
            .baseUrl(apiBaseUrl)
            .addConverterFactory(converterFactory())
            .build()
            .create(apiServiceInterface)
    }
}