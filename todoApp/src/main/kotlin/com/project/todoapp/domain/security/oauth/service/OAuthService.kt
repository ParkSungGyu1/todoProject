package com.project.todoapp.domain.security.oauth.service

import com.project.todoapp.domain.security.JwtPlugin
import com.project.todoapp.domain.security.oauth.KakaoOAuthClient
import com.project.todoapp.domain.security.oauth.KakaoOAuthUserInfo
import com.project.todoapp.domain.users.model.Users
import com.project.todoapp.domain.users.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class OAuthService (
    private val kakaoOAuthClient: KakaoOAuthClient,
    private val userRepository: UserRepository,
    private val jwtPlugin: JwtPlugin
){
    fun getLoginPage() : String{
        return kakaoOAuthClient.getLoginPageUrl()

    }

    fun login(code : String) : String{
        val accessToken = kakaoOAuthClient.getAccessToken(code)
        val userInfo = kakaoOAuthClient.getUserInfo(accessToken) as KakaoOAuthUserInfo

        //TODO("만약에 우리 db에 회원이 있다면 토큰 발급")
        //TODO("만약에 우리 db에 회원이 없다면 회원가입 진행 후 토큰 발급")
        val users = (userRepository.findByUserName(userInfo.properties.nickname)
            ?: userRepository.save(
                Users(
                    userName = userInfo.properties.nickname,
                    password = "",
                    oAuthProvider = "KAKAO"
                )
            ))

        return jwtPlugin.generateAccessToken("userName", users.userName)
    }
}