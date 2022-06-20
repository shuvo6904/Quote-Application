package com.example.quoteapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapplication.R
import com.example.quoteapplication.adapter.AuthorQuoteAdapter
import com.example.quoteapplication.databinding.ActivityQuoteAuthorBinding
import com.example.quoteapplication.viewmodel.QuoteAuthorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteAuthorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteAuthorBinding
    private lateinit var quoteAuthorViewModel : QuoteAuthorViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AuthorQuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuoteAuthorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val slug : String = intent.getStringExtra("slug").toString()
        val name : String = intent.getStringExtra("name").toString()
        binding.textView.text = "Quote From  -$name"

        recyclerView = findViewById(R.id.author_quote_recycler)

        quoteAuthorViewModel = ViewModelProvider(this).get(QuoteAuthorViewModel::class.java)

        quoteAuthorViewModel.getQuoteAuthor(slug)

        adapter = AuthorQuoteAdapter()

        /*binding.authorQuoteRecycler.layoutManager = LinearLayoutManager(this)
        binding.authorQuoteRecycler.setHasFixedSize(true)
        binding.authorQuoteRecycler.adapter = authorQuoteAdapter*/

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteAuthorViewModel.authorQuote.observe(this, Observer {

            adapter.authorQuote = it.results.toMutableList()
            adapter.notifyDataSetChanged()
            Log.d("SHUVO", it.results.toMutableList().toString())

        })


    }
}