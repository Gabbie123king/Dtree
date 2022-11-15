package com.lubnamariyam.retrofitapiinjetpackcompose.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lubnamariyam.retrofitapiinjetpackcompose.model.Group
import com.lubnamariyam.retrofitapiinjetpackcompose.network.ApiService
import kotlinx.coroutines.launch

class GroupViewModel : ViewModel() {

    var groupListResponse:List<Group> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getgroupList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val groupList = apiService.getData()
                groupListResponse = groupList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}