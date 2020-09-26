package com.example.mynativeapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.fastjson.JSON
import com.example.mynativeapp.db.DBHelper
import com.example.mynativeapp.db.GithubUrl
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import okio.IOException

class MainActivity : AppCompatActivity() {
    private val api = "https://api.github.com/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onRefresh()
    }

    private fun onRefresh() {
        Handler().postDelayed({ getGithubEndpoint() }, 5000)
    }

    private fun getGithubEndpoint() {
        try {
            val request = Request.Builder()
                .url(api)
                .build()

            OKHttpClientBuilder.buildOKHttpClient()
                .build()
                .newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("请求失败", "onFailure: " + e.message)
//                    Toast.makeText(applicationContext,e.message,Toast.LENGTH_SHORT).show()
                }
                @Throws(IOException::class)
                override fun onResponse(call: Call, response: Response) {
                    val respJson = response.body!!.string()
                    var githubUrl: GithubUrl = JSON.parseObject(respJson, GithubUrl::class.java)
                    updateData(githubUrl)
                    Log.i("getGithubEndpoint:", respJson!!)
//                    textView.text = respJson

                }

            })

//            textView.text = respJson
        } catch (e: Exception) {
            e.message?.let { Log.e("getGithubEndpoint:", it) }
        }
    }

    private fun updateData(githubUrl: GithubUrl) {
        var dbHelper:DBHelper? = DBHelper.getInstance(this)
        dbHelper?.createOrUpdate(githubUrl)

    }

    private fun initData() {
        var dbHelper:DBHelper? = DBHelper.getInstance(this)
        var githubUrl:GithubUrl = dbHelper?.queryGithubUrl()!!.get(dbHelper?.queryGithubUrl().size-1)
        textView.text = JSON.toJSONString(githubUrl)
    }

    public fun goHistory(view: View){
        var intent:Intent = Intent(this,HistoryActivity::class.java)
        startActivity(intent)
    }
}