package com.transporte.app.data.remote

import com.transporte.app.data.remote.dto.LoginResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface EmtApiService {
    @GET("v1/mobilitylabs/user/login/")
    suspend fun login(
        @Header("X-ClientId") clientId: String,
        @Header("X-SecretKey") secretKey: String
    ): Response<LoginResponseDTO>
}