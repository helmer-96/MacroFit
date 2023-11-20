package com.example.macrofit.domain.model

data class FoodModel(
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