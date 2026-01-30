package com.transporte.app.data.remote.api

import com.transporte.app.data.remote.dto.LoginResponseDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

// Define aquí unos DTOs rápidos para que no te den error hasta que los crees en archivos aparte
data class ArriveRequestDTO(val stopId: String = "")
data class ArriveResponseDTO(val data: List<Any> = emptyList())

interface EmtApiService {
    // 1. Login para obtener el token
    @GET("v1/mobilitylabs/user/login/")
    suspend fun login(
        @Header("X-ClientId") clientId: String,
        @Header("X-SecretKey") secretKey: String
    ): Response<LoginResponseDTO>

    // 2. Obtener tiempos de llegada (ejemplo)
    @POST("v2/transport/busemtmad/stops/{stopId}/arrives/")
    suspend fun getArriveStop(
        @Header("accessToken") token: String,
        @Path("stopId") stopId: String,
        @Body requestBody: ArriveRequestDTO
    ): Response<ArriveResponseDTO>
}