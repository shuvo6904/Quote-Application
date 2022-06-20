package com.example.quoteapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.quoteapplication.model.AuthorDetails
import com.example.quoteapplication.model.AuthorQuote
import com.example.quoteapplication.paging.QuotePagingSource
import com.example.quoteapplication.retrofit.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {


    fun getQuote() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {QuotePagingSource(quoteApi)}
    ).liveData


    private val authorLiveData = MutableLiveData<AuthorDetails>()

    val author : LiveData<AuthorDetails>
    get() = authorLiveData

    suspend fun getAuthor(query : String){
        val result = quoteApi.getAuthor(query)

        if (result?.body() != null){

            authorLiveData.postValue(result.body())

        }
    }


    private val authorQuoteLiveData = MutableLiveData<AuthorQuote>()

    val quoteAuthor : LiveData<AuthorQuote>
    get() = authorQuoteLiveData

    suspend fun getQuoteAuthor(slug : String){

        val result = quoteApi.getAuthorQuotes(slug)

        if (result.body() != null){

            authorQuoteLiveData.postValue(result.body())
        }

    }

}