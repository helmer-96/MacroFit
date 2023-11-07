package com.example.macrofit.ui.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.macrofit.R
import com.example.macrofit.ui.MainActivity
import com.google.android.material.appbar.MaterialToolbar

class DetalleComidaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                //delect SearchView
                val topAppBar=(activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
                    menu.clear()
                }
                DetalleComida()
            }
        }
    }






}

@Composable
private fun DetalleComida() {
    Text(
        text = "Este es el Fragmento de Detalle de Comida",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,


    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetalleComidaView() {
    DetalleComida()
}
