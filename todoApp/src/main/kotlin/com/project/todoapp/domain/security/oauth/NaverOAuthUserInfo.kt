package com.project.todoapp.domain.security.oauth

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class NaverOAuthUserInfo (
    val resultcode : String,
    val message : String,
    val response : NaverUserInfoProperties
) : OAuthUserInfoResponse
