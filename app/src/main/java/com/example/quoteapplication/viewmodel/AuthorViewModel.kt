package com.example.quoteapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapplication.model.AuthorDetails
import com.example.quoteapplication.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel(){

        fun getAuthorDetails(query : String){
            viewModelScope.launch(Dispatchers.IO) {
                repository.getAuthor(query)
            }
        }



    val author : LiveData<AuthorDetails>
    get() = repository.author
}