package com.rig.retrofit_hilt.retrofit

import com.rig.retrofit_hilt.data.Element
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("1")
    suspend fun getElement():Response<Element>
}