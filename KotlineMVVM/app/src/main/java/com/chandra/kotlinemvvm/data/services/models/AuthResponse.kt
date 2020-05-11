package com.chandra.kotlinemvvm.data.services.models

import com.chandra.kotlinemvvm.data.localdb.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)