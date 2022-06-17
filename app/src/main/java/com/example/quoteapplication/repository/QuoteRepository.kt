package com.example.quoteapplication.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.quoteapplication.paging.QuotePagingSource
import com.example.quoteapplication.retrofit.QuoteApi
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi) {

    fun getQuote() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {QuotePagingSource(quoteApi)}
    ).liveData

}