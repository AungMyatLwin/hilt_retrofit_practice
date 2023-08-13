package com.rig.retrofit_hilt.repo

import com.rig.retrofit_hilt.retrofit.ApiService
import javax.inject.Inject


class Repository(private  val apiService: ApiService) {
    suspend fun getElement() = apiService.getElement()
}