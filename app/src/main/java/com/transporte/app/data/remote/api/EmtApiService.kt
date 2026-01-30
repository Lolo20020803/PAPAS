package com.transporte.app.data.remote.api

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