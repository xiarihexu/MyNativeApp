package com.example.mynativeapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mynativeapp.R
import com.example.mynativeapp.db.GithubUrl

class HistoryAdapter(context: Context,val githubUrlList: List<GithubUrl>) : BaseAdapter() {
    private val inflater: LayoutInflater
    override fun getCount(): Int {
        return githubUrlList.size ?: 0
    }

    override fun getItem(position: Int): Any {
        return githubUrlList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(
        position: Int,
        convertView: View,
        parent: ViewGroup
    ): View {
        val view = inflater.inflate(R.layout.history_list_item, null)
        val githubUrl = getItem(position) as GithubUrl
        val tv_name = view.findViewById<View>(R.id.textView) as TextView
        tv_name.text = githubUrl.toString()
        return view
    }

    init {
        inflater = LayoutInflater.from(context)
    }
}