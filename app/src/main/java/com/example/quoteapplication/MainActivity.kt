package com.example.quoteapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapplication.paging.QuotePagingAdapter
import com.example.quoteapplication.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var quoteViewModel : QuoteViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : QuotePagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.quote_list_recycler)
        quoteViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        adapter = QuotePagingAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        quoteViewModel.list.observe(this, Observer {
            adapter.submitData(lifecycle, it)
        })
    }
}