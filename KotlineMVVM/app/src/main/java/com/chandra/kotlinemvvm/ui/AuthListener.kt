package com.chandra.kotlinemvvm.ui

import com.chandra.kotlinemvvm.data.localdb.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message:String)

}