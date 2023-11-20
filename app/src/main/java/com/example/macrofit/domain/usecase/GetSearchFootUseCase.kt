package com.example.macrofit.domain.usecase

import com.example.macrofit.data.repository.FoodRepositoryImpl
import com.example.macrofit.domain.model.FoodModel
import kotlinx.coroutines.flow.Flow

object GetSearchFootUseCase {
    suspend fun useCaseSearchFood(query: String): List<FoodModel> {
        return FoodRepositoryImpl().getFoodList(query)
    }
}