package com.example.macrofit.data.service

import com.example.macrofit.data.dto.FoodDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {
    @GET("nutrition")
    suspend fun getFoodList(
        @Query("query") query: String,
        @Header("X-Api-Key") apiKey : String = "o217EscCnWsoVjy1yVUGIA==6wQ6686Ge1Wp15nO"
    ): Response<FoodDTO>

}
