package com.transporte.app.data.repository
import com.transporte.app.data.remote.api.EmtApiService

class TransportRepositoryImpl(
    private val apiService: EmtApiService,
    private val clientId: String,
    private val secretKey: String
) : TransportRepository {

    private var cachedToken: String? = null

    private suspend fun getValidToken(): String {
        if (cachedToken == null) {
            val response = apiService.login(clientId, secretKey)
            cachedToken = response.body()?.data?.get(0)?.accessToken
        }
        return cachedToken ?: throw Exception("Error de autenticación")
    }

    override suspend fun getArrivalTimes(stopId: String): List<Arrival> {
        val token = getValidToken()
        val response = apiService.getArriveStop(token, stopId, ArriveRequestDTO())
        // Mapear DTO a Domain Model
        return response.body()?.toDomain() ?: emptyList()
    }
}

