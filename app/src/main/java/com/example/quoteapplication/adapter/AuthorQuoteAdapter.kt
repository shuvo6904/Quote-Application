package com.example.quoteapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapplication.R
import com.example.quoteapplication.model.AuthorQuote
import com.example.quoteapplication.model.ResultXX

class AuthorQuoteAdapter : RecyclerView.Adapter<AuthorQuoteAdapter.AuthorQuoteViewHolder>() {


    var authorQuote = mutableListOf<ResultXX>()

    class AuthorQuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.author_quote)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorQuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.author_quote_item, parent, false)
        return AuthorQuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: AuthorQuoteViewHolder, position: Int) {
        holder.textView.text = authorQuote[position].content
    }

    override fun getItemCount(): Int {
        return authorQuote.size
        Log.d("SHUVO2", authorQuote.size.toString())
    }
}