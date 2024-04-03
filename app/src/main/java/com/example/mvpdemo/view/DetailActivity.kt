package com.example.mvpdemo.view

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mvpdemo.R

class DetailActivity : AppCompatActivity() {

    lateinit var detail_back : ImageButton
    lateinit var detail_title : TextView
    lateinit var detail_year : TextView
    lateinit var detail_type : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        detail_back= findViewById(R.id.detail_back)
        detail_title= findViewById(R.id.detail_title)
        detail_year= findViewById(R.id.detail_year)
        detail_type= findViewById(R.id.detail_type)
        val title = "Title: ${intent.getStringExtra(Constants.TITLE)}"
        val type = "Type: ${intent.getStringExtra(Constants.TYPE)}"
        val year = "Year: ${intent.getStringExtra(Constants.YEAR)}"
        detail_title.text = title
        detail_year.text = year
        detail_type.text = type
        detail_back.setOnClickListener { finish() }
    }

    object Constants {
        const val TITLE = "title"
        const val TYPE = "type"
        const val YEAR = "year"
    }
}