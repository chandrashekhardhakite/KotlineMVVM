package com.chandra.kotlinemvvm.ui

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.chandra.kotlinemvvm.R
import com.chandra.kotlinemvvm.data.localdb.AppDataBase
import com.chandra.kotlinemvvm.data.localdb.entities.User
import com.chandra.kotlinemvvm.data.repository.AuthRepository
import com.chandra.kotlinemvvm.data.services.APIService
import com.chandra.kotlinemvvm.data.services.ServiceGenrator
import com.chandra.kotlinemvvm.databinding.LoginActivityBinding
import com.chandra.kotlinemvvm.util.hide
import com.chandra.kotlinemvvm.util.show
import com.chandra.kotlinemvvm.util.snackbar
import com.chandra.kotlinemvvm.vm.AuthViewModel
import com.chandra.kotlinemvvm.vm.AuthViewModelFactory
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity(), AuthListener {

    val TAG: String = "LoginActivity"
    lateinit var apiService: APIService
    lateinit var appDataBase: AppDataBase
    lateinit var  authRepository: AuthRepository
   lateinit var authViewModelFactory:AuthViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: LoginActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.login_activity)
        apiService = ServiceGenrator.invoke()
        appDataBase = AppDataBase.invoke(this)
        authRepository = AuthRepository(apiService,appDataBase)
        authViewModelFactory = AuthViewModelFactory(authRepository)
        val viewModel = ViewModelProvider(this,authViewModelFactory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this



    }

    override fun onStarted() {
        Log.i(TAG,"onStarted")
        progress_bar.show()
        root_layout.snackbar("Login Started")
//        toast("Login Started")

    }

    override fun onSuccess(user: User) {
        Log.i(TAG,"onSucess")
        progress_bar.hide()
        root_layout.snackbar("Login onSucess ${user.email}")
    }


    override fun onFailure(message: String) {
        Log.i(TAG,"onFailure")
        progress_bar.hide()
        root_layout.snackbar("Login onFailure $message")
    }
}
