package com.example.mynativeapp.db

import android.content.Context
import com.litesuits.orm.LiteOrm
import com.litesuits.orm.db.assit.QueryBuilder


/**
 * LiteOrm数据库工具类
 */
class DBHelper private constructor(context: Context) {
    /**
     * 上下文
     */
    private val context: Context

    /**
     * 数据库实例
     */
    private val orm: LiteOrm

    /**
     * 创建或更新GithubUrl数据
     *
     * @param data
     */
    fun createOrUpdate(data: GithubUrl) {
        orm.save(data)
    }

    /**
     * 查询所有GithubUrl数据
     *
     * @return
     */
    fun queryGithubUrl(): List<GithubUrl> {
        val queryBuilder: QueryBuilder<GithubUrl> =
            QueryBuilder<GithubUrl>(GithubUrl::class.java)
        return orm.query<GithubUrl>(queryBuilder)
    }

    /**
     * 删除GithubUrl数据
     *
     * @param data
     */
    fun deleteGithubUrl(data: GithubUrl?) {
        orm.delete(data)
    }

    companion object {
        /**
         * 数据库工具类实例
         */
        private var instance: DBHelper? = null

        /**
         * 获取数据库工具类单例
         *
         * @param context
         * @return
         */
        fun getInstance(context: Context): DBHelper? {
            if (instance == null) {
                instance = DBHelper(context.getApplicationContext())
            }
            return instance
        }
    }

    /**
     * 构造方法
     *
     * @param context
     */
    init {
        this.context = context

        //创建数据库实例
        orm = LiteOrm.newSingleInstance(context, "MyNativeApp.db")

        //设置调试模式
        orm.setDebugged(true)
    }
}
