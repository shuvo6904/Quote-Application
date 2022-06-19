package com.example.quoteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quoteapplication.viewmodel.AuthorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorDetailsActivity : AppCompatActivity() {

    lateinit var authorViewModel : AuthorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_details)

        val authorName = findViewById<TextView>(R.id.author_name)
        val authorBio = findViewById<TextView>(R.id.author_bio)

        val author : String = intent.getStringExtra("author").toString()

        authorViewModel = ViewModelProvider(this).get(AuthorViewModel::class.java)

        authorViewModel.getAuthorDetails(author)
        authorViewModel.author.observe(this, Observer {

            authorName.text = it.results.get(0).name
            authorBio.text = it.results.get(0).bio

        })

    }
}