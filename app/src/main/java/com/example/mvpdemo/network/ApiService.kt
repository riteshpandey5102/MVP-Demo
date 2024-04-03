package com.example.mvcdemo.network

import com.example.mvpdemo.model.BookModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/shorts")
    fun fetchData(): Single<BookModel>
}