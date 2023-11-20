package com.example.macrofit.ui.home.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.macrofit.R


@Composable
fun HomeView(onClick: () -> Unit={}, salirClick:()->Unit={}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
    )
    {
        Header()
        Row(
            Modifier.padding(10.dp, 40.dp)
        ) {
            CardItemFood()
            Spacer(modifier = Modifier.width(10.dp))
            CardItemAddFood(onClick = onClick)
        }
        CardExit(salirClick)
    }
}

@Composable
fun Header() {
    Text(
        textAlign = TextAlign.Center,
        text = stringResource(R.string.calorias),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 30.dp, 0.dp, 0.dp)
    )
    Text(
        textAlign = TextAlign.Center,
        text = "550".plus(" Kcal"),
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun CardItemFood() {
    Card(
        backgroundColor = Color.Cyan,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(180.dp)
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp),
                painter = painterResource(R.drawable.baseline_food_bank_24),
                contentDescription = null
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Ir a comidas",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CardItemAddFood(onClick: () -> Unit = {}) {
    Card(
        backgroundColor = Color.Cyan,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .width(180.dp)
            .height(80.dp)
            .clickable {
                onClick()
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp),
                painter = painterResource(R.drawable.baseline_dinner_dining_24),
                contentDescription = null
            )
            Text(
                textAlign = TextAlign.Center,
                text = "Añadir comida",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun CardExit(salirClick:()->Unit = {}) {
    Card(
        backgroundColor = Color.Red,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(20.dp, 0.dp)
            .clickable {
                salirClick()
            }
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Salir",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    HomeView()
}
