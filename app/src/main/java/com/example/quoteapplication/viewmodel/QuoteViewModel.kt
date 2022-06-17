package com.example.quoteapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.quoteapplication.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {
    val list = repository.getQuote().cachedIn(viewModelScope)
}