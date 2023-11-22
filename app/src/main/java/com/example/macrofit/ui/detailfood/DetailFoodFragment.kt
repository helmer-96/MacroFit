package com.example.macrofit.ui.detailfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.macrofit.R
import com.example.macrofit.ui.MainActivity
import com.google.android.material.appbar.MaterialToolbar

class DetailFoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                //delect SearchView
                val topAppBar =
                    (activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
                        menu.clear()
                    }
                DetailFoodFragmentView()
            }
        }
    }

}

@Composable
fun DetailFoodFragmentView() {
    Column(modifier = Modifier.padding(16.dp))
    {
        Text(
            text = "Titulo comida",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
        Row(modifier = Modifier.padding(16.dp))
        {
            Text(
                text = "Grasas: ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "100g",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Row(modifier = Modifier.padding(16.dp))
        {
            Text(
                text = "Carbohidratos: ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "100g",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Row(modifier = Modifier.padding(16.dp))
        {
            Text(
                text = "Proteinas: ",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "100g",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Text(text = "Cantidades: ",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth())
    }

}

@Preview(showSystemUi = true)
@Composable
private fun DetailFoodPreview() {
    DetailFoodFragmentView()
}
