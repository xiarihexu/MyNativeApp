package com.example.mynativeapp

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.example.mynativeapp.adapter.HistoryAdapter
import com.example.mynativeapp.db.DBHelper
import com.example.mynativeapp.db.GithubUrl
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.*

class HistoryActivity : AppCompatActivity() {
    var githubUrlList: List<GithubUrl>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        var dbHelper: DBHelper? = DBHelper.getInstance(this)
        githubUrlList = dbHelper!!.queryGithubUrl()
        var historyAdapter = HistoryAdapter(this, githubUrlList!!)
        listView.setAdapter(historyAdapter)
    }


}