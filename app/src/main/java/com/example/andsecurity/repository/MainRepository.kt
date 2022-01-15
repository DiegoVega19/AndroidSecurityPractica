package com.example.andsecurity.repository

import com.example.andsecurity.Api.RetrofitInstance
import com.example.andsecurity.Model.Login
import com.example.andsecurity.Model.Register
import retrofit2.Response

class MainRepository {

    suspend fun loginUser(login: Login): Response<Login> {
        return RetrofitInstance.api.login(login)
    }
    suspend fun registerUser(register: Register): Response<Register> {
        return RetrofitInstance.api.register(register)
    }

}