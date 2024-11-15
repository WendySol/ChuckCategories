package com.example.jockes.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jockes.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject() constructor(private val getCategoriesUC: GetCategoriesUseCase) :
    ViewModel() {


    private val _litCategories = MutableStateFlow<List<String>>(emptyList())
    val listCategories: StateFlow<List<String>> get() = _litCategories

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    private val _error = MutableStateFlow<String>("")
    val error: StateFlow<String> get() = _error

    init {
        getCategories()
    }

    fun getCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _litCategories.value = getCategoriesUC()
            } catch (e: Exception) {

                _error.value = e.message!!
            }
            _isLoading.value = false

        }

    }


}