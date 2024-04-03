package com.example.mvpdemo.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvcdemo.adapter.Adapter
import com.example.mvpdemo.R
import com.example.mvpdemo.model.DataItem
import com.example.mvpdemo.model.MainModel
import com.example.mvpdemo.presenter.MainPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var mainPresenter: MainPresenter
    private lateinit var mainModel: MainModel
    private lateinit var adapter: Adapter

    private lateinit var main_activity_recyclerView: RecyclerView
    private lateinit var main_activity_progress_bar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadView()
        mainModel= MainModel()
        mainPresenter = MainPresenter(mainModel,this)
        mainPresenter.fetchData()
    }

    private fun loadView() {
        setContentView(R.layout.activity_main)
        adapter = Adapter()
        main_activity_recyclerView = findViewById(R.id.main_activity_recyclerView)
        main_activity_progress_bar = findViewById(R.id.main_activity_progress_bar)
        main_activity_recyclerView.adapter = adapter
        adapter setItemClickMethod { goToDetailActivity(it) }
        adapter.setItemShowMethod { mainPresenter fetchItemTextFrom it }
    }

    fun goToDetailActivity(item: DataItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.Constants.TITLE, item.title)
        intent.putExtra(DetailActivity.Constants.TYPE, item.type)
        intent.putExtra(DetailActivity.Constants.YEAR, item.year.toString())
        startActivity(intent)
    }

    fun updateRecyclerView(t: List<DataItem>) {
        adapter.updateList(t)
        adapter.notifyDataSetChanged()
    }

    fun showProgressBar() {
        main_activity_progress_bar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        main_activity_progress_bar.visibility = View.GONE
    }

    fun showErrorMessage(errorMsg: String) {
        Toast.makeText(this, "Error retrieving data: $errorMsg", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.onStop()
    }
}