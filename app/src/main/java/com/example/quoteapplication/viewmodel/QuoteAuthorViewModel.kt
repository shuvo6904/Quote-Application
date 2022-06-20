package com.example.quoteapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapplication.model.AuthorQuote
import com.example.quoteapplication.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteAuthorViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    val authorQuote : LiveData<AuthorQuote>
    get() = repository.quoteAuthor

    fun getQuoteAuthor(slug : String){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuoteAuthor(slug)
        }
    }

}