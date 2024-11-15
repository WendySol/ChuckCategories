package com.example.jockes.di

import com.example.jockes.data.datasource.remote.JokeApi
import com.example.jockes.data.respository.CategoryRepositoryImpl
import com.example.jockes.domain.repository.CategoryRepository
import com.example.jockes.domain.usecase.GetCategoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RespositoryModule {
    @Provides
    @Singleton
    fun providesRepository(jokeApi: JokeApi): CategoryRepository {
        return CategoryRepositoryImpl(jokeApi)
    }
    @Provides
    @Singleton
    fun providesGetCategoriesUC(repository:CategoryRepository): GetCategoriesUseCase{
        return GetCategoriesUseCase(repository)
    }



}