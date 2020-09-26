package com.example.mynativeapp.db

import com.litesuits.orm.db.annotation.PrimaryKey
import com.litesuits.orm.db.annotation.Table
import com.litesuits.orm.db.enums.AssignType

@Table("GithubUrlTable")
class GithubUrl {
    /**
     * id
     * PrimaryKey:主键
     * BY_MYSELF:使用该字段的值
     * 还可以指定自动生成
     */
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    var id:Integer? = null
    var label_search_url: String? = null
    var organization_repositories_url: String? = null
    var user_repositories_url: String? = null
    var gists_url: String? = null
    var notifications_url: String? = null
    var following_url: String? = null
    var keys_url: String? = null
    var user_search_url: String? = null
    var feeds_url: String? = null
    var starred_gists_url: String? = null
    var user_url: String? = null
    var repository_url: String? = null
    var user_organizations_url: String? = null
    var current_user_authorizations_html_url: String? = null
    var emojis_url: String? = null
    var organization_url: String? = null
    var hub_url: String? = null
    var starred_url: String? = null
    var followers_url: String? = null
    var emails_url: String? = null
    var rate_limit_url: String? = null
    var commit_search_url: String? = null
    var issues_url: String? = null
    var organization_teams_url: String? = null
    var public_gists_url: String? = null
    var authorizations_url: String? = null
    var events_url: String? = null
    var current_user_url: String? = null
    var current_user_repositories_url: String? = null
    var issue_search_url: String? = null
    var code_search_url: String? = null
    var repository_search_url: String? = null

}