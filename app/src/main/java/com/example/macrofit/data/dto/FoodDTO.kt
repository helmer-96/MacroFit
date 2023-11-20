package com.example.macrofit.data.dto

import com.example.macrofit.domain.model.FoodModel
import com.google.gson.annotations.SerializedName

class FoodDTO : ArrayList<FoodDTOItem>()

data class FoodDTOItem(
    val name: String,
    val calories: Double,
    val serving_size_g: Int,
    val fat_total_g: Double,
    val protein_g: Double,
    val sodium_mg: Int,
    val cholesterol_mg: Int,
    val carbohydrates_total_g: Int,
    val sugar_g: Int,
)

fun FoodDTOItem.toFoodModel(): FoodModel {
    return FoodModel(
        name = name,
        calories = calories,
        serving_size_g = serving_size_g,
        fat_total_g = fat_total_g,
        protein_g = protein_g,
        sodium_mg = sodium_mg,
        cholesterol_mg = cholesterol_mg,
        carbohydrates_total_g = carbohydrates_total_g,
        sugar_g = sugar_g,
    )
}