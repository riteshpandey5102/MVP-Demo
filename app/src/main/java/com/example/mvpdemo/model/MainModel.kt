package com.example.mvpdemo.model

import com.example.mvcdemo.network.RetrofitClient
import io.reactivex.Single

class MainModel {

    fun fetchData(): Single<BookModel> {
        return RetrofitClient.getApiService().fetchData()
    }

}