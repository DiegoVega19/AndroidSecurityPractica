package com.example.andsecurity.Api

import com.example.andsecurity.Model.Login
import com.example.andsecurity.Model.Register
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {


    @POST("login")
    suspend fun login(
        @Body login: Login
    ): Response<Login>

    @POST("register")
    suspend fun register(
        @Body register: Register
    ): Response<Register>

}