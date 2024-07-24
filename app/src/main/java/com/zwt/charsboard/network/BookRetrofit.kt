package com.zwt.charsboard.network

import android.util.Log
import com.zwt.charsboard.data.remote.BookResponse
import com.zwt.charsboard.util.Const.Companion.BASE_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BookRetrofit {
    private val bookNetworkService: BookNetworkService = createBookService(createRetrofit())

    private fun createBookService(retrofit: Retrofit): BookNetworkService {
        return retrofit.create(BookNetworkService::class.java)
    }

    private fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getBookResults() : Call<BookResponse> {
       // return bookNetworkService.getBookResponse(s)
        Log.d("TAG_X", "getBookResults: In getBooks")
        return bookNetworkService.getBookResponse()
    }





}