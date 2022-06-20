package com.example.quoteapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quoteapplication.R
import com.example.quoteapplication.viewmodel.AuthorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorDetailsActivity : AppCompatActivity() {

    lateinit var authorViewModel : AuthorViewModel
    lateinit var progressBar: ProgressBar
    lateinit var slug : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_details)

        progressBar = findViewById(R.id.progressbar)

        val authorName = findViewById<TextView>(R.id.author_name)
        val authorBio = findViewById<TextView>(R.id.author_bio)
        val authorLink = findViewById<TextView>(R.id.author_link)
        val authorDes = findViewById<TextView>(R.id.author_des)

        val author : String = intent.getStringExtra("author").toString()

        authorViewModel = ViewModelProvider(this).get(AuthorViewModel::class.java)
        authorViewModel.getAuthorDetails(author)



        authorViewModel.author.observe(this, Observer {

            //Log.d("S", it.toString())

            progressBar.visibility = View.GONE

            authorName.text = it.results.get(0).name
            authorBio.text = it.results.get(0).bio
            authorDes.text = it.results.get(0).description
            authorLink.text = it.results.get(0).link

            slug = it.results.get(0).slug

        })

    }

    fun getAuthorQuotes(view: View) {
        val intent = Intent(this, QuoteAuthorActivity::class.java)
        intent.putExtra("slug", slug)
        startActivity(intent)
    }
}