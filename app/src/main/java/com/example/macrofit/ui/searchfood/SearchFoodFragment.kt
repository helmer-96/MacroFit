package com.example.macrofit.ui.searchfood

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.macrofit.R
import com.example.macrofit.ui.MainActivity
import com.example.macrofit.ui.searchfood.compose.SearchFoodFragmentView
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class AddComidaFragment : Fragment() {
    private lateinit var searchView: SearchView
    private val viewModel by viewModels<SearFoodViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(inflater.context).apply {
            lifecycleScope.launch {
                viewModel.stateFlow.collectLatest { state ->
                    setContent {
                        when (state) {
                            is SearchFoodState.Loading -> {}
                            is SearchFoodState.SearchFoodOk -> {
                                SearchFoodFragmentView(
                                    onClick = {},
                                    food= state.foodList
                                )
                            }
                            is SearchFoodState.SearchFoodError -> { Toast.makeText(context, "Error datos", Toast.LENGTH_SHORT).show() }
                        }
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        config()
    }

    private fun hideKeyboard() {
        // Hide the keyboard.
        val inputMethodManager =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    private fun config() {
        val topAppBar =
            (activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
                inflateMenu(R.menu.menu_search)
            }
        searchView = topAppBar.menu.findItem(R.id.searchId).actionView as SearchView
        searchView.queryHint = "Buscar comida"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Se llama cuando se presiona el botón de búsqueda o se envía el formulario
                // Aquí puedes realizar la búsqueda con el texto ingresado (query)
                // Devuelve true para indicar que se ha manejado el evento
                if (query != null) {
                    viewModel.getAll(query)

                } else
                    Toast.makeText(context, "No se encontraron resultados", Toast.LENGTH_SHORT)
                        .show()
                hideKeyboard()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Se llama cuando el texto en el SearchView cambia
                // Aquí puedes realizar acciones mientras el usuario escribe
                // newText contiene el texto actualizado
                return true
            }
        })
    }

    override fun onDestroy() {
        //delect SearchView
        val topAppBar =
            (activity as MainActivity).findViewById<MaterialToolbar>(R.id.toolBar).apply {
                menu.clear()
            }
        super.onDestroy()

    }

}
