package com.example.quoteapplication.model

data class AuthorDetails(
    val count: Int,
    val lastItemIndex: Any,
    val page: Int,
    val results: List<ResultX>,
    val totalCount: Int,
    val totalPages: Int
)