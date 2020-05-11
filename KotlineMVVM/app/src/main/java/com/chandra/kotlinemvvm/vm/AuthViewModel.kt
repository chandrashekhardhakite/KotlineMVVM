package com.chandra.kotlinemvvm.vm

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.chandra.kotlinemvvm.data.repository.AuthRepository
import com.chandra.kotlinemvvm.data.services.ServiceGenrator
import com.chandra.kotlinemvvm.ui.AuthListener
import com.chandra.kotlinemvvm.ui.SignupActivity
import com.chandra.kotlinemvvm.util.ApiException
import com.chandra.kotlinemvvm.util.Couroutines
import com.chandra.kotlinemvvm.util.NoInternetException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class AuthViewModel(
    private val repository: AuthRepository


    ) : ViewModel() {

    val TAG: String = "AuthViewModel"

    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null
    fun onLoginButtonClick(view: View) {

        Log.i(TAG, "Sign In - onLoginButtonClick called ")
        authListener?.onStarted()

        if (email.isNullOrBlank() || password.isNullOrBlank()) {
            authListener?.onFailure("email or password field is empty")
            return
        }

        Couroutines.main {

            try {
                val authResponse = repository.getUser(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    withContext(Dispatchers.IO){
                        repository.saveUser(it)
                    }
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }

    fun onSignup(view: View) {
        Intent(view.context, SignupActivity::class.java).also {
            view.context.startActivity(it)
        }
    }


}