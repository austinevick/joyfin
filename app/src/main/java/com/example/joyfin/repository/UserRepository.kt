package com.example.joyfin.repository

import com.example.joyfin.model.UserData
import retrofit2.Response
import retrofit2.http.GET

interface UserRepository {
    @GET("teni/mobilebackend/main/mock.json")
    suspend fun userData(): Response<UserData>
}