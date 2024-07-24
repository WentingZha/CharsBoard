package com.zwt.charsboard.network

import com.zwt.charsboard.data.remote.BookResponse
import com.zwt.charsboard.util.Const.Companion.PATH
import retrofit2.Call
import retrofit2.http.GET

interface BookNetworkService {

    @GET(PATH)
    fun getBookResponse() : Call<BookResponse>
}