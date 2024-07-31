package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.User
import com.example.myapplication.data.repository.IApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserListViewModel @Inject constructor(val repository: IApiRepository): ViewModel() {
    val _allUsers = MutableStateFlow <List<User?>?> (emptyList())
    val allUsers: MutableStateFlow<List<User?>?> = _allUsers

    init {
        getAllUsersVM()
    }
    private fun getAllUsersVM(){
        viewModelScope.launch {
            try {
                val allUsersResponse = repository.getAllUserList().users

                _allUsers.value = allUsersResponse
                Log.i("Data ", allUsersResponse[0].email.toString())
            }catch (ex: Exception){
                Log.i("Data error", ex.message.toString())
            }
        }
    }
}