package br.com.playershub.dependencyInjection

import br.com.playershub.data.rawgGamesApi.RawgVideoGameRepository
import br.com.playershub.domain.boundary.GamesBoundary
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationBindingModule {

    @Binds
    abstract fun bindGamesBoundary(repository: RawgVideoGameRepository): GamesBoundary
}