package com.example.jockes.di

import com.example.jockes.data.datasource.remote.JokeApi
import com.example.jockes.data.respository.CategoryRepositoryImpl
import com.example.jockes.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesJokeApi(retrofit: Retrofit): JokeApi {

        return retrofit.create(JokeApi::class.java)
    }


}