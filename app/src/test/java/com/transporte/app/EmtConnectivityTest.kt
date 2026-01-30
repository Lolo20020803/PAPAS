package com.transporte.app

import com.transporte.app.data.remote.api.EmtApiService
import com.transporte.app.di.NetworkModule
import kotlinx.coroutines.runBlocking
import org.junit.Test

class EmtConnectivityTest {

    @Test
    fun verifyEmtConnection() = runBlocking {
        // 1. Inicializamos manualmente los componentes del NetworkModule
        val okHttpClient = NetworkModule.provideOkHttpClient()
        val retrofit = NetworkModule.provideRetrofit(okHttpClient)
        val service = NetworkModule.provideEmtApiService(retrofit)

        // 2. Tus credenciales de MobilityLabs
        val clientId = ""
        val secretKey = ""

        println("🚀 Iniciando petición de login a la EMT...")

        try {
            val response = service.login(clientId, secretKey)

            if (response.isSuccessful) {
                val loginData = response.body()?.data?.firstOrNull()
                if (loginData != null) {
                    println("✅ CONEXIÓN EXITOSA")
                    println("🔑 Access Token: ${loginData.accessToken}")
                    println("📅 Caduca el: ${loginData.expirationDate}")
                } else {
                    println("⚠️ Respuesta exitosa pero sin datos (lista vacía)")
                }
            } else {
                println("❌ ERROR DE CONEXIÓN")
                println("Código: ${response.code()}")
                println("Mensaje: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            println("💥 Error crítico al conectar: ${e.message}")
            e.printStackTrace()
        }
    }
}