package com.example.macrofit.ui.searchfood

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.macrofit.domain.model.FoodModel
import com.example.macrofit.domain.usecase.GetSearchFootUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class SearFoodViewModel : ViewModel() {
    private val _stateFlow: MutableStateFlow<SearchFoodState> =
        MutableStateFlow(SearchFoodState.Loading)
    val stateFlow: MutableStateFlow<SearchFoodState> = _stateFlow

    fun getAll(query: String) {
        viewModelScope.launch {
            GetSearchFootUseCase.useCaseSearchFood(query).onEach {
                Log.d("FOOT", "getAll: $it")
                _stateFlow.value = SearchFoodState.SearchFoodOk(it)
            }
        }
    }
}

sealed class SearchFoodState {
    object Loading : SearchFoodState()
    data class SearchFoodOk(val foodList: FoodModel) : SearchFoodState()
    data class SearchFoodError(val error: String) : SearchFoodState()
}