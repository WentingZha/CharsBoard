package com.zwt.charsboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zwt.charsboard.R
import com.zwt.charsboard.data.remote.Item

class BookAdapter(private var bookList: List<Item>) :
    RecyclerView.Adapter<BookAdapter.BookHolder>() {

    fun updateBookList(bookList: List<Item>) {
        this.bookList = bookList
    }

    class BookHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvTitle: TextView = itemview.findViewById(R.id.tv_title)
        val tvAuthor: TextView = itemview.findViewById(R.id.tv_author)
        val ivImageUrl: ImageView = itemview.findViewById(R.id.iv_book_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder =
        BookHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))

    override fun getItemCount(): Int = bookList.size

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
        val bookItem = bookList[position]
        holder.apply {
            tvTitle.text = bookItem.volumeInfo.title
            tvAuthor.text = bookItem.volumeInfo.authors[0]

            val imageLinks = bookItem.volumeInfo.imageLinks
            if (imageLinks == null) {
                ivImageUrl.setImageResource(R.mipmap.ic_launcher)
            } else {
                Glide.with(tvTitle.context)
                    .load(imageLinks.smallThumbnail)
                    .centerCrop()
                    .into(ivImageUrl)
            }



        }
    }
}