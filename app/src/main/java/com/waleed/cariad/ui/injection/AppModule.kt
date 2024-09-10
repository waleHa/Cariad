package com.waleed.cariad.ui.injection

import com.waleed.cariad.ui.repositry.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun providerepo (): MovieRepository{
        return MovieRepository()
    }
}