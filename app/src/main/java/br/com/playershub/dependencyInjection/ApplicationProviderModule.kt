package br.com.playershub.dependencyInjection

import br.com.playershub.data.rawgGamesApi.clients.RawgGamesClient
import br.com.playershub.data.rawgGamesApi.interceptors.RawgGamesApiInterceptor
import br.com.playershub.data.rawgGamesApi.sources.RawgGamesApiDataSource
import br.com.playershub.data.utils.ApiUtilsProvider
import br.com.playershub.data.utils.VIDEO_GAME_DB_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object ApplicationProviderModule {

    @Provides
    fun provideRawgDataSource(): RawgGamesApiDataSource {
        return ApiUtilsProvider.retrofit(
            apiBaseUrl = VIDEO_GAME_DB_URL,
            apiServiceInterface = RawgGamesApiDataSource::class.java,
            authInterceptor = RawgGamesApiInterceptor()
        )
    }

    @Provides
    fun providesGamesClient(dataSource: RawgGamesApiDataSource) = RawgGamesClient(dataSource)
}