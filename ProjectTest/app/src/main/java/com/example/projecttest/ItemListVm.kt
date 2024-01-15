package com.example.projecttest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemListVm: ViewModel() {

    private  val _itemList = mutableStateListOf<String>()
    var errorMessage:String by mutableStateOf("")
    val itemList:List<String>
        get() = _itemList

    fun getItemList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                _itemList.clear()
                _itemList.addAll(apiService.getItems())

            } catch (e:Exception){
                errorMessage = e.message.toString()
            }


        }
    }

}