package com.example.macrofit.domain.repository

import com.example.macrofit.domain.model.FoodModel
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
   suspend fun getFoodList(query: String): List<FoodModel>
}