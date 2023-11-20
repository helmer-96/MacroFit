package com.example.macrofit.data.source

import com.example.macrofit.data.RetrofitServiceFactory
import com.example.macrofit.data.dto.toFoodModel
import com.example.macrofit.data.service.RetrofitService
import com.example.macrofit.domain.model.FoodModel

class SearchFoodDataSource {
    suspend fun getFoodList(query: String): List<FoodModel> {
        val response = RetrofitServiceFactory.makeRetrofitService().getFoodList(query)
        return response.body()!!.map {
            it.toFoodModel()
        }
    }
}