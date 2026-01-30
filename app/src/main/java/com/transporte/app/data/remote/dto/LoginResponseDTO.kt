package com.transporte.app.data.remote.dto

data class LoginResponseDTO(
    val code: String,
    val description: String,
    val data: List<LoginDataDTO>
)

data class LoginDataDTO(
    val accessToken: String,
    val expirationDate: String
)