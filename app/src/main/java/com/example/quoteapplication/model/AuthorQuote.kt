package com.example.quoteapplication.model

data class AuthorQuote(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ResultXX>,
    val totalCount: Int,
    val totalPages: Int
)