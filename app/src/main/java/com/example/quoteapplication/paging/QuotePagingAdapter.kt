package com.example.quoteapplication.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapplication.R
import com.example.quoteapplication.model.Result

class QuotePagingAdapter : PagingDataAdapter<Result, QuotePagingAdapter.QuoteViewHolder>(COMPARATOR){

    class QuoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val quote = itemView.findViewById<TextView>(R.id.quote)
        val author = itemView.findViewById<TextView>(R.id.author)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {

        val item = getItem(position)
        if (item != null) {
            holder.quote.text = item.content
            holder.author.text = item.author
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote_layout, parent, false)
        return QuoteViewHolder(view)
    }

    companion object{
        private val COMPARATOR = object: DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }
}