package com.example.macrofit.ui.searchfood.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.macrofit.domain.model.FoodModel


@Composable
fun SearchFoodFragmentView(
    onClick: () -> Unit = {},
    food: FoodModel,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item() {
            FoodItemView(
                onClick = onClick,
                food = food,
            )
        }
    }
}

@Composable
private fun FoodItemView(
    onClick: () -> Unit = {},
    food: FoodModel,
) {
    Card(
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(0.dp, 8.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp, 12.dp)
        ) {
            Text(
                text = food.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Row {
                Text(
                    text = "Grasas:${food.fat_total_g}g",
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Proteinas:${food.protein_g}g",
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Carbohidratos:${food.carbohydrates_total_g}g"
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Kcal: ${food.calories}"
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable()
fun DetailPreview() {
    SearchFoodFragmentView(
        onClick = {},
        food = FoodModel(
            name = "Arroz",
            calories = 100.0,
            serving_size_g = 100,
            fat_total_g = 100.0,
            protein_g = 100.0,
            sodium_mg = 100,
            cholesterol_mg = 100,
            carbohydrates_total_g = 100,
            sugar_g = 100,
        )
    )
}

