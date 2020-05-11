package com.chandra.kotlinemvvm

import android.app.Application
import com.chandra.kotlinemvvm.data.localdb.AppDataBase
import com.chandra.kotlinemvvm.data.repository.AuthRepository
import com.chandra.kotlinemvvm.data.services.APIService
import com.chandra.kotlinemvvm.data.services.ServiceGenrator
import com.chandra.kotlinemvvm.vm.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication :Application(){



}