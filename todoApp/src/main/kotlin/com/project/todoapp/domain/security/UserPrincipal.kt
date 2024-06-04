package com.project.todoapp.domain.security

import com.project.todoapp.domain.users.model.Users

data class UserPrincipal (
    val id : Long,
    val userName : String
) {
    fun to() : Users{
        return Users(
            id = id,
            userName = userName,
            password = "",
        )
    }
}