package com.project.todoapp.domain.security.oauth

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserInfoProperties (
    val nickname : String
)
