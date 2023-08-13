package com.rig.retrofit_hilt.retrofit

import com.rig.retrofit_hilt.data.Element
import com.rig.retrofit_hilt.repo.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilerApi {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/todos/"

    @Provides
    fun provideRetrofitBuilder():Retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService =
        retrofit.create(ApiService::class.java)

    @Provides
    fun providesRepository(apiService: ApiService) = Repository(apiService)
}