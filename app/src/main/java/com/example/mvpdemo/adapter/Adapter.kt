package com.example.mvcdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpdemo.R
import com.example.mvpdemo.model.DataItem

class Adapter : RecyclerView.Adapter<Adapter.Holder>() {
    var mList: List<DataItem> = arrayListOf()
    private lateinit var mOnClick: (item: DataItem) -> Unit
    private lateinit var mOnShowItem: (item: DataItem) -> String

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.item_textView.text = mOnShowItem(mList[position])
        holder.itemView.setOnClickListener { mOnClick(mList[position]) }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    infix fun setItemClickMethod(onClick: (item: DataItem) -> Unit) {
        this.mOnClick = onClick
    }

    infix fun setItemShowMethod(onShowItem: (item: DataItem) -> String) {
        this.mOnShowItem = onShowItem
    }

    fun updateList(list: List<DataItem>) {
        mList = list
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val item_textView = itemView.findViewById<TextView>(R.id.item_textView)
    }
}
