package com.example.projecttest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductListVm: ViewModel() {

    private  val _productList = mutableStateListOf<Product>()
    var errorMessage:String by mutableStateOf("")
    val productList:List<Product>
        get() = _productList

    fun getProductList(categoryName : String){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                _productList.clear()
                _productList.addAll(apiService.getProduct(categoryName))

            } catch (e:Exception){
                errorMessage = e.message.toString()
            }

            for (i in _productList){
                println("product ${_productList.size}")
            }
        }
    }

}