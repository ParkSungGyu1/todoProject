package com.project.todoapp.domain.security.oauth.controller

import com.project.todoapp.domain.security.oauth.service.OAuthService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class OAuthController(
    private val oAuthService: OAuthService
) {

    @GetMapping("/oauth/kakao")
    fun getLoginPage() : String{
        return oAuthService.getLoginPage()
    }

    @GetMapping("/kakao/callback")
    fun callback(
        @RequestParam code :String
    ) : String{
        return oAuthService.login(code)
    }


}