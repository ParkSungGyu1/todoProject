package com.project.todoapp.domain.security.oauth

interface OAuthClient {
    fun getLoginPageUrl() : String
    fun getAccessToken(code : String) : String
    fun getUserInfo(accessToken : String) : OAuthUserInfoResponse
}