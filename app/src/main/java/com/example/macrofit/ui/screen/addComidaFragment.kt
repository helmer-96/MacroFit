package com.example.macrofit.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.findNavController
import com.example.macrofit.R
import com.example.macrofit.ui.MainActivity
import com.google.android.material.appbar.MaterialToolbar


class AddComidaFragment : Fragment() {
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
               InitComida (
                   onClick = {
                      findNavController().navigate(R.id.action_addComidaFragment_to_detalleComidaFragment)
                   }
               )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        config()
    }


    private fun config(){
        val topAppBar=(activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
            inflateMenu(R.menu.menu_search)
        }
        searchView=topAppBar.menu.findItem(R.id.searchId).actionView as SearchView
        searchView.queryHint="Buscar comida"
    }
    override fun onDestroy() {
        //delect SearchView
        val topAppBar=(activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
            menu.clear()
        }
        super.onDestroy()


    }
}


@Composable
private fun InitComida(onClick: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        item(){
            for (i in 1..10) {
                Body(onClick)
            }
        }
    }
}

@Composable
private fun Body(onClick: () -> Unit) {
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
                text = "Titulo comida",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
            Row {
                Text(
                    text = "Grasas: 0g",
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Proteinas: 0g",
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Carbohidratos: 0g"
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = "Kcal: 0"
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable()
fun DetailScreen() {
      //  InitComida()
}
