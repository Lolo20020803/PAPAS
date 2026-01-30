package com.transporte.app

import com.transporte.app.di.NetworkModule
import kotlinx.coroutines.runBlocking
import org.junit.Test

class EmtConnectivityTest {

    @Test
    fun `verificar conexion con EMT devuelve token`() = runBlocking {
        // 1. Preparamos Retrofit usando tu modulo de DI
        val retrofit = NetworkModule.provideRetrofit(NetworkModule.provideOkHttpClient())
        val service = NetworkModule.provideEmtApiService(retrofit)

        // 2. TUS CREDENCIALES (Cámbialas por las tuyas)
        val clientId = "TU-CLIENT-ID-AQUI"
        val secretKey = "TU-SECRET-KEY-AQUI"

        // 3. Ejecutamos la llamada
        val response = service.login(clientId, secretKey)

        // 4. Comprobamos el resultado en la consola
        if (response.isSuccessful) {
            val token = response.body()?.data?.get(0)?.accessToken
            println("✅ CONEXIÓN EXITOSA. Token recibido: $token")
        } else {
            println("❌ ERROR: ${response.code()} - ${response.errorBody()?.string()}")
        }

        assert(response.isSuccessful)
    }
}