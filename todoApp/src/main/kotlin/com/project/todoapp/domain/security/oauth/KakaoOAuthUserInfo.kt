package com.project.todoapp.domain.security.oauth

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class KakaoOAuthUserInfo (
    val id : Long,
    val properties : UserInfoProperties
) : OAuthUserInfoResponse
