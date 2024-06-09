package com.project.todoapp.domain.security.oauth

class NaverOAuthClient : OAuthClient {
    override fun getLoginPageUrl(): String {
        TODO("Not yet implemented")
    }

    override fun getAccessToken(code: String): String {
        TODO("Not yet implemented")
    }

    override fun getUserInfo(accessToken: String): OAuthUserInfoResponse {
        TODO("Not yet implemented")
    }
}