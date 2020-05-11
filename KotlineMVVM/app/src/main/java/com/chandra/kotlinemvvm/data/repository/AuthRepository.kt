package com.chandra.kotlinemvvm.data.repository

import android.util.Log
import com.chandra.kotlinemvvm.data.localdb.AppDataBase
import com.chandra.kotlinemvvm.data.localdb.entities.User
import com.chandra.kotlinemvvm.data.services.APIService
import com.chandra.kotlinemvvm.data.services.SafeApiRequest
import com.chandra.kotlinemvvm.data.services.models.AuthResponse

class AuthRepository(
    private val apiService: APIService,
    private val appDataBase: AppDataBase
):SafeApiRequest(){

    val TAG:String = "AuthRepository"

    suspend fun getUser(email:String, password:String):AuthResponse{
        return apiRequest {apiService.userLogin(email,password)}
    }

    suspend fun saveUser(user: User){
        Log.i(TAG,"saveUser  ${user.email}")
        val id = appDataBase.getUserDao().insertUser(user)
        Log.i(TAG,"saveUser  ${user.id}")
    }

}