package com.zwt.charsboard.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zwt.charsboard.network.BookRetrofit
import com.zwt.charsboard.data.remote.BookResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class BookViewModel : ViewModel() {
    private val executor: ExecutorService = Executors.newCachedThreadPool()
    private var bookResult: MutableLiveData<BookResponse> = MutableLiveData()

    fun lookUpBooks(): LiveData<BookResponse> {
        executor.execute{
            BookRetrofit.getBookResults().enqueue(object: Callback<BookResponse> {
                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }

                override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                    bookResult.postValue(response.body())
                }

            })
        }

        return bookResult

    }

}