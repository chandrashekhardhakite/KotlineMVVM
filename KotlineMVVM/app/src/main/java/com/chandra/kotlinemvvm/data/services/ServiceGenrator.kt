package com.chandra.kotlinemvvm.data.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenrator {
    var apiService: APIService?=null
    var BASEURL:String = "https://api.simplifiedcoding.in/course-apis/mvvm/"

    operator fun invoke():APIService{

       return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }


}