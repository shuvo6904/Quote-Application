package com.example.quoteapplication.di

import com.example.quoteapplication.retrofit.Constant.BASE_URL
import com.example.quoteapplication.retrofit.QuoteApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getQuoteApi(retrofit: Retrofit) : QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }

}