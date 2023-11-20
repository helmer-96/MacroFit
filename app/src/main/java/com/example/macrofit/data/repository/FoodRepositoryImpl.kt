package com.example.macrofit.data.repository

import com.example.macrofit.data.source.SearchFoodDataSource
import com.example.macrofit.domain.model.FoodModel
import com.example.macrofit.domain.repository.FoodRepository

class FoodRepositoryImpl: FoodRepository {
    override suspend fun getFoodList(query: String): List<FoodModel>{
        return  SearchFoodDataSource().getFoodList(query)
    }
}
