package com.example.myapplication.di

import com.example.myapplication.data.api.APIDetails
import com.example.myapplication.data.api.IApiEndpoint
import com.example.myapplication.data.repository.ApiRepositoryImpl
import com.example.myapplication.data.repository.IApiRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    //retrofit
    @Provides
    fun provideRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(APIDetails.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // api
    @Provides
    fun provideApiService(retrofit: Retrofit): IApiEndpoint{
        return retrofit.create(IApiEndpoint::class.java)
    }

    // repository
    @Provides
    fun provideRepository(iApiEndpoint: IApiEndpoint): IApiRepository{
        return  ApiRepositoryImpl(iApiEndpoint)
    }
}