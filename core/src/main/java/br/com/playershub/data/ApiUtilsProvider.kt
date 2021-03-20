package br.com.playershub.data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtilsProvider {
    private val authInterceptor = AuthInterceptor()
    private val logInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun httpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logInterceptor)
            .build()
    }

    fun converterFactory(): GsonConverterFactory {
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