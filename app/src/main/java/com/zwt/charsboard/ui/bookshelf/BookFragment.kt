package com.zwt.charsboard.ui.bookshelf

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.zwt.charsboard.R
import com.zwt.charsboard.adapter.BookAdapter
import com.zwt.charsboard.data.remote.Item
import com.zwt.charsboard.viewmodel.BookViewModel

class BookFragment : Fragment() {

    private val bookAdapter = BookAdapter(mutableListOf())
    private lateinit var recyclerView: RecyclerView
    fun updateList(list:List<Item>){
        bookAdapter.updateBookList(list)
        bookAdapter.notifyDataSetChanged()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_book_list)
        recyclerView.adapter = bookAdapter

        val bookViewModel = ViewModelProvider(this)[BookViewModel::class.java]

        bookViewModel.lookUpBooks().observe(viewLifecycleOwner) {
            Log.d("TAG", "lookUpBooks: $it")
            if (it!= null)
                it.items?.let { it1 -> updateList(it1) }
        }
    }


}