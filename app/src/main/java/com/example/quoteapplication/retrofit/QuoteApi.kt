package com.example.quoteapplication.retrofit

import com.example.quoteapplication.model.AuthorDetails
import com.example.quoteapplication.model.AuthorQuote
import com.example.quoteapplication.model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("quotes")
    suspend fun getQuote(@Query("page") page : Int) : QuoteList
    ///quotes?page=1

    @GET("search/authors")
    suspend fun getAuthor(@Query("query") query : String) : Response<AuthorDetails>
    ///search/authors?query=Einstein

    @GET("quotes")
    suspend fun getAuthorQuotes(@Query("author") slug : String) : Response<AuthorQuote>
    ///quotes?author=albert-einstein

}