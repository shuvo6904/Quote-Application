package com.example.quoteapplication.retrofit

import com.example.quoteapplication.model.QuoteList
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getQuote(@Query("page") page : Int) : QuoteList

}