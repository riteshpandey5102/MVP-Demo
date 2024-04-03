package com.example.mvpdemo.presenter

import com.example.mvpdemo.view.MainActivity
import com.example.mvpdemo.model.BookModel
import com.example.mvpdemo.model.DataItem
import com.example.mvpdemo.model.MainModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainPresenter() {
    private lateinit var mainView: MainActivity
    private lateinit var mainModel: MainModel
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    constructor(mainModel: MainModel,mainActivity: MainActivity) : this() {
        this.mainModel = mainModel
        this.mainView=mainActivity
    }

    fun fetchData() {
        val disposable: Disposable = mainModel.fetchData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<BookModel?>() {
            override fun onSuccess(t: BookModel) {
                mainView.hideProgressBar()
                mainView.updateRecyclerView(t.data)
            }

            override fun onStart() {
                mainView.showProgressBar()
            }

            override fun onError(e: Throwable) {
                mainView.hideProgressBar()
                mainView.showErrorMessage(e.message!!)
            }
        })
        compositeDisposable.add(disposable)
    }

    infix fun fetchItemTextFrom(it: DataItem): String {
        return "${it.year}: ${it.title}"
    }
    fun onStop() {
        compositeDisposable.clear()
    }

}