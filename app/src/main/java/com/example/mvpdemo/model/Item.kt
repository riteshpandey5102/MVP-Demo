package com.example.mvpdemo.model

data class BookModel(val data: List<DataItem>)

data class DataItem(val collectedIn: String = "",
                    val notes: List<String>,
                    val year: Int = 0,
                    val originallyPublishedIn: String? = "",
                    val createdAt: String? = "",
                    val handle: String? = "",
                    val id: Int? = 0,
                    val title: String = "",
                    val type: String = "")