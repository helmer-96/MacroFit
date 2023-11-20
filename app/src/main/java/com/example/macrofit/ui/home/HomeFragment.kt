package com.example.macrofit.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.example.macrofit.R
import com.example.macrofit.ui.home.compose.HomeView

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                HomeView( onClick = {
                    findNavController().navigate(R.id.action_homeFragment_to_addComidaFragment)
                },
                salirClick = {
                  requireActivity().finish()
                })
            }
        }

    }

}
